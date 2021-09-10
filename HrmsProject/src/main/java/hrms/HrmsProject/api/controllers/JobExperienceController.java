package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.ResumeExperienceService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeExperience;
import hrms.HrmsProject.entities.dtos.ResumeExperinceDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceController {

	private ResumeExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceController(ResumeExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	 @PostMapping("/add")
	    public ResponseEntity<?> add(@RequestBody ResumeExperinceDto experianceForSetDto){
	        Result result = this.jobExperienceService.add(experianceForSetDto);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }
	
	/*@PostMapping("/update")
	public Result update( @RequestBody ResumeExperience jobExperience){
		return this.jobExperienceService.update(jobExperience);
		
	}*/
	
	@PostMapping("/delete")
	public Result delete( @RequestParam int experianceId){
		return this.jobExperienceService.delete(experianceId);
		
	}
	
	@GetMapping("/getByCvId")
    public DataResult<List<ResumeExperience>> getByCvId(@RequestParam int id){
        return this.jobExperienceService.getByCvId(id);
    }
	
	/*@GetMapping("/getall")
	public DataResult<List<ResumeExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeExperience>> getAllByCandidateId(@RequestParam int id){
		return this.jobExperienceService.getAllByJobSeekerId(id);
	}*/
	/*@GetMapping("/getById")
	public DataResult<ResumeExperience> getById(@RequestParam int id){
		return this.jobExperienceService.getById(id);
	}	*/
	/*@GetMapping("/getAllByCandidateIdOrderByDesc")
	public DataResult<List<ResumeExperience>> getAllByCandidateIdOrderByDesc(@RequestParam int id){
		return this.jobExperienceService.getAllByJobSeekerIdOrderByDesc(id);
	}*/
}
