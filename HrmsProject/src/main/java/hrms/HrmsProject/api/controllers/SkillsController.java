package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.ResumeSkillService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeSkill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

private ResumeSkillService resumeSkillService;
	
	
	@Autowired
	public SkillsController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody ResumeSkill resumeSkill){
		return this.resumeSkillService.add(resumeSkill);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody ResumeSkill resumeSkill){
		return this.resumeSkillService.update(resumeSkill);
		
	}
	
	@PostMapping("/delete")
	public Result delete( @RequestParam int  id){
		return this.resumeSkillService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeSkill>> getAll(){
		return this.resumeSkillService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeSkill>> getAllByJobSeekerId(@RequestParam int id){
		return this.resumeSkillService.getAllByJobSeekerId(id);
	}
	/*@GetMapping("/getById")
	public DataResult<ResumeSkill> getById(@RequestParam int id){
		return this.resumeSkillService.getById(id);
	}*/
}
