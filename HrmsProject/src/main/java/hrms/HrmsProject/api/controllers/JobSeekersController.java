package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.JobSeekerService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobSeeker;
import hrms.HrmsProject.entities.dtos.JobSeekerRegisterDto;
import hrms.HrmsProject.entities.dtos.JobSeekerResumeDto;

@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class JobSeekersController {
	
	private JobSeekerService candidateService;
	
	@Autowired
	public JobSeekersController(JobSeekerService candidateService) {
		super();
		this.candidateService = candidateService;
	}
		
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.candidateService.getAll();
	}
		
	/*@PostMapping("/add")
	public Result add(@RequestBody JobSeeker candidate) {
		return this.candidateService.add(candidate);
		
	}*/
	@PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobSeekerRegisterDto candidateForRegisterDto){
        Result result=this.candidateService.add(candidateForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
	
	/*@GetMapping("/getJobseekerCVById")
	public DataResult<JobSeekerResumeDto> getCandidateCVById(@RequestParam int id){
		return this.candidateService.getCandidateCVById(id);
	}
	*/
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(@RequestParam int id){
		return this.candidateService.getById(id);
	}


}