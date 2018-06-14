package sentiment.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.Session;

import sentiment.file.handler.FileStorageException;
import sentiment.file.handler.MyFileNotFoundException;
import sentiment.model.FeedbackSentence;
import sentiment.model.Lecturer;
import sentiment.model.Semeter;
import sentiment.model.Subject;
import sentiment.repositories.DepartmentRepository;
import sentiment.repositories.FeedbackSentenceRepository;
import sentiment.repositories.LecturerRepository;
import sentiment.repositories.SemeterRepository;
import sentiment.repositories.SubjectRepository;
import sentiment.storage.FileStorageProperties;
import uit.sentiment.maxent.PredictSentence;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	private LecturerRepository lecturerRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private SemeterRepository semeterRepository;

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public String storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

	@Transactional
	public void parseFeedback(String fileName) {
		PredictSentence pre = new PredictSentence("model/sentiment.model", "model/topic.model");

		File src = new File("uploads/" + fileName);
		XSSFWorkbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
			int rowCount = sheet1.getLastRowNum();
			for (int i = 0; i < rowCount; i++) {

				String content = "";
				try {
				content = sheet1.getRow(i).getCell(9).getStringCellValue()
						+ "." + sheet1.getRow(i).getCell(9).getStringCellValue();
				
				}catch (NullPointerException e) {
					content = "";
				} catch(java.lang.IllegalStateException e) {
					content = "";
				}

				if (content.trim().length() != 0) {
					String[] temp = content.split("\\.");

					String subjectCode = sheet1.getRow(i).getCell(5).getStringCellValue().trim();
					String subjectName = sheet1.getRow(i).getCell(6).getStringCellValue().trim();
					String departmentId = sheet1.getRow(i).getCell(2).getStringCellValue().trim();
					String lecturerName = sheet1.getRow(i).getCell(4).getStringCellValue().trim();

					int subjectId;
					List<Subject> listSub = subjectRepository.findBySubjectCode(subjectCode);
					if (listSub.isEmpty()) {
						Subject sub = new Subject(subjectCode, subjectName);
						subjectRepository.save(sub);
					}
					subjectId = subjectRepository.findBySubjectCode(subjectCode).get(0).getId();

					int semeterId;
					fileName = fileName.replaceAll("\\.xlsx", "");
					fileName = fileName.replaceAll("\\s+", "_");
					List<Semeter> listSem = semeterRepository.findBySemeterName(fileName);
					if (listSem.isEmpty()) {
						Semeter sem = new Semeter(fileName);
						semeterRepository.save(sem);
					}
					semeterId = semeterRepository.findBySemeterName(fileName).get(0).getId();
					

					int lecturerId = -1;
					List<Lecturer> listLec = lecturerRepository.findByLecturerName(lecturerName);
					if (listLec.isEmpty()) {
						Lecturer lec = new Lecturer(lecturerName);
						lecturerRepository.save(lec);
					}
					
					lecturerId = lecturerRepository.findByLecturerName(lecturerName).get(0).getId();

					for (String str : temp) {
						FeedbackSentence sent = new 
								FeedbackSentence(str, Integer.valueOf(pre.predictTopic(str)), Integer.valueOf(pre.predictSentiment(str)), lecturerId, subjectId, departmentId, semeterId);
						feedbackSentenceRepository.save(sent);

					}
				}

			}
		} catch (FileNotFoundException ex) {
			System.out.println("Không tìm thấy file");
		} catch (IOException ex) {
			System.out.println("Lỗi");
		} finally {
			try {
				wb.close();
			} catch (IOException ex) {
				System.out.println("Lỗi");
			}
		}
	}
}
