package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.model.FeedbackSentence;
import sentiment.repositories.FeedbackSentenceRepository;

@RestController
public class FeedbackController {
	@Autowired
	private FeedbackSentenceRepository feedbackSentenceRepository;
	
	@RequestMapping("/feedback/getall")
	public List<FeedbackSentence> getListLecturer(){
		return feedbackSentenceRepository.findAll();
	}
}
