package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/subject/{subjectID}/{semID}")
	public JsonType getRatio(@PathVariable("subjectID") Integer subjectID, @PathVariable("semID") Integer semID) {
		return subjectService.getRatio(subjectID, semID);
	}
	
	@RequestMapping("/subject/{subjectID}")
	public List<ChartElement> returnJsonChart(@PathVariable("subjectID") Integer subjectID){
		return subjectService.returnJsonChart(subjectID);
	}
	
	@RequestMapping("/subject/feedback/{subjectID}/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable Integer subjectID, @PathVariable Integer semID){
		return subjectService.getFeedback(subjectID, semID);
	}
}
