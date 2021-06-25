package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.EmployerService;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Employer;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	
	@GetMapping("/getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.register(employer);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Employer employer) {
		return this.employerService.delete(employer);
		
	}
	
}