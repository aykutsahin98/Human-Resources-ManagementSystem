package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.ResumeEducationService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeEducation;
import hrms.HrmsProject.entities.dtos.ResumeEducationDto;

@CrossOrigin
@RestController
@RequestMapping("/api/educations")
public class EducationsController {
	
	private ResumeEducationService educationService;
	
	@Autowired
	public EducationsController(ResumeEducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducationDto schoolForCVDto){
		return this.educationService.addSchool(schoolForCVDto);
	}
	
	/*@PostMapping("/update")
	public Result update(@RequestBody ResumeEducation schoolForCV){
		return this.educationService.update(schoolForCV);
	}*/
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int schoolId){
		return this.educationService.deleteSchool(schoolId);
	}
	
	 @GetMapping("/getByCvId")
	    public DataResult<List<ResumeEducation>> getByCvId(@RequestParam int cvId){
	        return this.educationService.getByCvId(cvId);
	    }
	
	/*@GetMapping("/getbyid")
	public DataResult<ResumeEducation> getById(@RequestParam int id){
		return this.educationService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeEducation>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndDescd")
	public DataResult<List<ResumeEducation>> getAllByJobseekerIdOrderByEndedDateDesc(@RequestParam int id){
		return this.educationService.getAllByJobseekerIdOrderByEndedDateDesc(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeEducation>> getAllByCandidateId(@RequestParam int id){
		return this.educationService.getAllByJobSeekerId(id);
	}*/
				

}