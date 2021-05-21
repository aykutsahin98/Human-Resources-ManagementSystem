package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.JobTitleService;
import hrms.HrmsProject.entities.concretes.JobTittle;

@RestController
@RequestMapping ("/api/jobtitles")
public class JobTittleController {
	
	private JobTitleService jobTitleService;

	@Autowired
	public JobTittleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public List<JobTittle> getAll(){
		return this.jobTitleService.getAll();
	}
}
