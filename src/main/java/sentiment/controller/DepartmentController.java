package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsonTypeDepartmentFB;
import sentiment.service.DepartmentChartService;
import sentiment.service.DepartmentPercentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentPercentService departmentPercentServices;
	
	@Autowired
	private DepartmentChartService departmentChartService;
	
	@RequestMapping("/{depID}/{depSem}")
	public JsonType depart(@PathVariable("depID") String depID, @PathVariable("depSem") Integer depSem) {
		return departmentPercentServices.getPercent(depID, depSem);
	}
	
	@RequestMapping("/chart/{depID}")
	public List<ChartElement> returnChart(@PathVariable("depID") String depID){
		return departmentChartService.getChart(depID);
	}
	
	@RequestMapping("feedback/{depID}/{depSem}")
	public List<JsonTypeDepartmentFB> returnListofFb(@PathVariable("depID") String depID, @PathVariable("depSem") Integer depSem){
		return departmentPercentServices.getFeedbackFromDepartment(depID, depSem);
	}
	
}
