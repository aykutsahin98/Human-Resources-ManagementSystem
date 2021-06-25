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

import hrms.HrmsProject.business.abstracts.ResumeLinkService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeLink;

@CrossOrigin
@RestController
@RequestMapping("/api/links")
public class LinksController {
	
private ResumeLinkService resumeLinkService;
	
	@Autowired
	public LinksController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody ResumeLink resumeLink){
		return this.resumeLinkService.add(resumeLink);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody ResumeLink resumeLink){
		return this.resumeLinkService.update(resumeLink);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int  id){
		return this.resumeLinkService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeLink>> getAll(){
		return this.resumeLinkService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeLink>> getAllByJobSeekerId(@RequestParam int id){
		return this.resumeLinkService.getAllByJobSeekerId(id);
	}
	/*@GetMapping("/getById")
	public DataResult<ResumeLink> getById(@RequestParam int id){
		return this.resumeLinkService.getById(id);
	}*/

}
