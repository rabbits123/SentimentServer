package sentiment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.model.FeedbackSentence;
import sentiment.repositories.FeedbackSentenceRepository;

@Service
public class FacilityService {
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;
	
	@Autowired
	private DepartmentPercentService departmentPercentService;
	
	public JsonType getRatio(Integer semesterID) {
		JsonType jsonTypeLecturer = new JsonType();

		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();

		for (FeedbackSentence feedbackSentence : feedbackSentences) {
			int semeter_id = feedbackSentence.getSemeterid();
			int sentimentLabel = feedbackSentence.getSentimentlabel();
			int topicLabel = feedbackSentence.getTopiclabel();

			if (semeter_id == semesterID && topicLabel == 2) {
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
	
	
	public List<ChartElement> returnJsonChart() {
		List<ChartElement> chartList = new ArrayList<>();

		ArrayList<Integer> listSemester = departmentPercentService.getListSemester();

		for (int semester : listSemester) {
			ChartElement chart = new ChartElement();
			chart.setListPercent(getRatio(semester));
			chart.setSemester(semester);
			chart.caculateRatio();
			chartList.add(chart);
		}
		return chartList;
	}
	
	public List<JsontypeFeedback> getFeedback(int semesterID){
		List<FeedbackSentence> feedbackSentences = feedbackSentenceRepository.findAll();
		
		List<JsontypeFeedback> feedbacks = new ArrayList<>();
		
		for(FeedbackSentence feedback : feedbackSentences) {
			if(feedback.getSemeterid() == semesterID && feedback.getTopiclabel() == 2) {
				JsontypeFeedback json = new JsontypeFeedback(feedback.getContent(), feedback.getSentimentlabel());
				feedbacks.add(json);
			}
		}
		return feedbacks;
	}
	
}
