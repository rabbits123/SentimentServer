package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.json.type.ChartElement;
import sentiment.json.type.JsonType;
import sentiment.json.type.JsontypeFeedback;
import sentiment.model.Lecturer;
import sentiment.repositories.LecturerRepository;
import sentiment.service.LecturerDetailService;

@RestController
public class LecturerDetailController {
	@Autowired
	private LecturerDetailService lecturerDetailService;
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	
	@RequestMapping("/lecturedetails")
	public List<Lecturer> getListLecturer(){
		return lecturerDetailService.getListLecturer();
	}
	
	@RequestMapping("/lecturerdetails/{lecturerID}/{semID}")
	public JsonType getPercent(@PathVariable("lecturerID")Integer lecturerID, @PathVariable("semID") Integer semesterID) {
		return lecturerDetailService.getRatio(lecturerID, semesterID);
	}
	
	@RequestMapping("/lecturerdetails/chart/{lecturerID}")
	public List<ChartElement> returnJsonChart(@PathVariable("lecturerID") Integer lecturerID){
		return lecturerDetailService.returnJsonChart(lecturerID);
	}
	
	@RequestMapping("/lecturerdetails/feeback/{lecturerID}/{semID}")
	public List<JsontypeFeedback> getFeedback(@PathVariable("lecturerID") Integer lecturerID, @PathVariable("semID") Integer semID){
		return lecturerDetailService.getFeedback(lecturerID, semID);
		
	}
}
