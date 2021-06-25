package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.JobPositionService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobPosition;

@CrossOrigin
@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
				
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.delete(jobPosition);
		
	}
}
