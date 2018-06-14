package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.model.Lecturer;
import sentiment.repositories.LecturerRepository;
import sentiment.service.FileStorageService;
import sentiment.service.LecturerService;

@RestController
public class LecturerController {
	@Autowired
	private LecturerService lecturerService; 
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	@RequestMapping("/lecturer/getall")
	public List<Lecturer> getAllLecturer() { 
		return lecturerRepository.findAll();
	} 
	
	@RequestMapping("/lecturer/{semID}")
	public JsonType returnLecturer(@PathVariable("semID") Integer semID) {
		return lecturerService.getPercent(semID);
	} 
	
	@RequestMapping("/lecturer/chart")
	public List<ChartElement> returnJsonChart(){
		return lecturerService.returnJsonChart();
	}
	
	@RequestMapping("/lecturer/feedback/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable("semID") Integer semID){
		return lecturerService.getFeedback(semID);
	}
}
