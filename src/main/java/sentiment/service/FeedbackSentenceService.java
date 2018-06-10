package sentiment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sentiment.json.type.JsonTypeGeneral;
import sentiment.repositories.FeedbackSentenceRepository;

@Service
public class FeedbackSentenceService {
	
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;
	
	@Autowired
	private JsonTypeGeneralService jsonTypeGeneralService;


	public JsonTypeGeneral getAllFeedback() {
		return jsonTypeGeneralService.calculateJsonTypeGeneral(feedbackSentenceRepository.findAll());
	}
	
}
