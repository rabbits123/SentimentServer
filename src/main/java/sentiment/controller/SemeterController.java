package sentiment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sentiment.model.Semeter;
import sentiment.repositories.SemeterRepository;

@RestController
public class SemeterController {
	@Autowired
	private SemeterRepository semeterRepository;
	
	@RequestMapping("/semeter/getall")
	public List<Semeter> getListLecturer(){
		return semeterRepository.findAll();
	}
}
