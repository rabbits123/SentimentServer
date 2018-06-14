package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.service.FacilityService;

@RestController
public class FacilityController {
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping("/facility/{semID}")
	public JsonType getRatio(@PathVariable("semID") Integer semID) {
		return facilityService.getRatio(semID);
	}
	
	@RequestMapping("/facility/chart")
	public List<ChartElement> returnJsonChart(){
		return facilityService.returnJsonChart();
	}
	
	@RequestMapping("/facility/feedback/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable("semID") Integer semID){
		return facilityService.getFeedback(semID);
	}
}
