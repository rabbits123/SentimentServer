package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.service.CurriculumService;
import sentiment.service.DepartmentPercentService;

@RestController
public class CurriculumController {

	@Autowired
	private CurriculumService curriculumService;
	
	@Autowired
	private DepartmentPercentService departmentPercentService;
	
	@RequestMapping("/curriculum/{semID}")
	public JsonType returnRatio(@PathVariable("semID") Integer semID) {
		return curriculumService.getPercent(semID);
	}
	
	@RequestMapping("/curriculum/chart")
	public List<ChartElement> returnJsonChart(){
		return curriculumService.returnJsonChart();
	}
	
	@RequestMapping("/curriculum/feedback/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable("semID") Integer semID){
		return curriculumService.getFeedback(semID);
	}
	
	
	
}
