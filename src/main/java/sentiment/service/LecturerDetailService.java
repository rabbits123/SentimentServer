package sentiment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.model.FeedbackSentence;
import sentiment.model.Lecturer;
import sentiment.repositories.FeedbackSentenceRepository;
import sentiment.repositories.LecturerRepository;

@Service
public class LecturerDetailService {
	@Autowired
	private LecturerRepository lecturerRepository;
	
	@Autowired
	private DepartmentPercentService departmentPercentService;
	
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;
	
	public List<Lecturer> getListLecturer(){
		return lecturerRepository.findAll();
	}
	
	public List<ChartElement> returnJsonChart(int lecturerID) {
		List<ChartElement> chartList = new ArrayList<>();

		ArrayList<Integer> listSemester = departmentPercentService.getListSemester();

		for (int semester : listSemester) {
			ChartElement chart = new ChartElement();
			chart.setListPercent(getRatio(lecturerID, semester));
			chart.setSemester(semester);
			chart.caculateRatio();
			chartList.add(chart);
		}
		return chartList;
	}
	
	
	public JsonType getRatio(int lecturerID, int semesterID) {
		JsonType jsonTypeLecturer = new JsonType();

		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();

		for (FeedbackSentence feedbackSentence : feedbackSentences) {
			
			int semeter_id = feedbackSentence.getSemeterid();
			int sentimentLabel = feedbackSentence.getSentimentlabel();
			int lecturer_id =  feedbackSentence.getLecturerid();

			if (semeter_id == semesterID && lecturer_id == semesterID) {
				switch (sentimentLabel) {
				case 0:
					jsonTypeLecturer.setNegative();
					break;
				case 1:
					jsonTypeLecturer.setNeutral();
					break;
				case 2:
					jsonTypeLecturer.setPositive();
					break;
				}

			}
		}
		return jsonTypeLecturer;
	}
	
	public List<JsontypeFeedback> getFeedback(int lecturerID, int semesterID){
		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();
		
		List<JsontypeFeedback> feedbacks = new ArrayList<>();
		
		for(FeedbackSentence feedback : feedbackSentences) {
			if(feedback.getSemeterid() == semesterID && feedback.getLecturerid() == lecturerID) {
				JsontypeFeedback json = new JsontypeFeedback(feedback.getContent(), feedback.getSentimentlabel());
				feedbacks.add(json);
			}
		}
		return feedbacks;
	}
}
