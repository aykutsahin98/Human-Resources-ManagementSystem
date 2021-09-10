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

import hrms.HrmsProject.business.abstracts.ResumeCoverLetterService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeCoverLetter;
import hrms.HrmsProject.entities.concretes.ResumeEducation;

@CrossOrigin
@RestController
@RequestMapping("/api/coverletter")
public class CoverLetterController {

	private ResumeCoverLetterService coverLetterService;
	
	@Autowired
    public CoverLetterController(ResumeCoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody ResumeCoverLetter coverLetter){
		return this.coverLetterService.add(coverLetter);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody ResumeCoverLetter coverLetter){
		return this.coverLetterService.update(coverLetter);
		
	}
	
	@PostMapping("/delete")
	public Result delete( @RequestParam int letterId){
		return this.coverLetterService.delete(letterId);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeCoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeCoverLetter>> getAllByCandidateId(@RequestParam int id){
		return this.coverLetterService.getAllByJobSeekerId(id);
	}
	

	/*@GetMapping("/getById")
	public DataResult<ResumeCoverLetter> getById(@RequestParam int letterId){
		return this.coverLetterService.getById(letterId);
	}*/

}
