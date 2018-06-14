package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.model.Subject;
import sentiment.repositories.SubjectRepository;
import sentiment.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@RequestMapping("/subject/getall")
	public List<Subject> getAllSubject(){
		return subjectRepository.findAll();
	}
	
	@RequestMapping("/subject/{subjectID}/{semID}")
	public JsonType getRatio(@PathVariable("subjectID") int subjectID, @PathVariable("semID") Integer semID) {
		return subjectService.getRatio(subjectID, semID);
	}
	
	@RequestMapping("/subject/{subjectID}")
	public List<ChartElement> returnJsonChart(@PathVariable("subjectID") int subjectID){
		return subjectService.returnJsonChart(subjectID);
	}
	
	@RequestMapping("/subject/feedback/{subjectID}/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable int subjectID, @PathVariable Integer semID){
		return subjectService.getFeedback(subjectID, semID);
	}
}
