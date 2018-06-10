package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.service.LecturerService;

@RestController
public class LecturerController {
	@Autowired
	private LecturerService lecturerPercentService;
	
	@RequestMapping("/lecturer/{semID}")
	public JsonType returnLecturer(@PathVariable("semID") Integer semID) {
		return lecturerPercentService.getPercent(semID);
	} 
	
	@RequestMapping("/lecturer/chart")
	public List<ChartElement> returnJsonChart(){
		return lecturerPercentService.returnJsonChart();
	}
	
	@RequestMapping("/lecturer/feedback/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable("semID") Integer semID){
		return lecturerPercentService.getFeedback(semID);
	}
}
