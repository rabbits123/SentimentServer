package sentiment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sentiment.json.type.JsonType;
import sentiment.json.type.JsonTypeDepartmentFB;
import sentiment.model.FeedbackSentence;
import sentiment.repositories.FeedbackSentenceRepository;

@Service
public class DepartmentPercentService {
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;

	public JsonType getPercent(String departmentID, Integer semesterID) {
		JsonType jsonTypeDepartment = new JsonType();

		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();

		for (FeedbackSentence feedbackSentence : feedbackSentences) {
			String department_id = feedbackSentence.getDepartmentid();
			int semeter_id = feedbackSentence.getSemeterid();
			int sentimentLabel = feedbackSentence.getSentimentlabel();
			
			if (department_id.equals(departmentID) && semeter_id == semesterID) {
				switch (sentimentLabel) {
				case 0:
					jsonTypeDepartment.setNegative();
					break;
				case 1:
					jsonTypeDepartment.setNeutral();
					break;
				case 2:
					jsonTypeDepartment.setPositive();
					break;
				}

			}
		}
		return jsonTypeDepartment;
	}
	
	public List<JsonTypeDepartmentFB> getFeedbackFromDepartment(String departmentID, Integer semesterID){
		List<JsonTypeDepartmentFB> listJson = new ArrayList<>();

		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();
		for (FeedbackSentence feedbackSentence : feedbackSentences) {
			String department_id = feedbackSentence.getDepartmentid();
			int semeter_id = feedbackSentence.getSemeterid();
			int sentimentLabel = feedbackSentence.getSentimentlabel();
			int topicLabel = feedbackSentence.getTopiclabel();
			String feedback = feedbackSentence.getContent();
			if (department_id.equals(departmentID) && semeter_id == semesterID) {
				JsonTypeDepartmentFB jsonTypeDepartmentFB = new JsonTypeDepartmentFB(feedback, sentimentLabel, topicLabel);
				listJson.add(jsonTypeDepartmentFB);
			}
		}
		
		return listJson;
	}
	
	

	// return all semester list
	public ArrayList<Integer> getListSemester() {
		List<Integer> listSemester = new ArrayList<>();
		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();

		for (FeedbackSentence feedbackSentence : feedbackSentences) {
			int semester_id = feedbackSentence.getSemeterid();
			if(!listSemester.contains(semester_id)) {
				listSemester.add(semester_id);
			} 
		}
		return (ArrayList<Integer>) listSemester;
	}
}
