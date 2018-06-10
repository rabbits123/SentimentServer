package sentiment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.JsonTypeGeneral;
import sentiment.service.FeedbackSentenceService;

@RestController
public class GeneralController {
	
	@Autowired
	private FeedbackSentenceService feedbackSentenceService;
	
	@RequestMapping("/generals")
	public JsonTypeGeneral getJsonGeneral() {
		return feedbackSentenceService.getAllFeedback();
	}
}
