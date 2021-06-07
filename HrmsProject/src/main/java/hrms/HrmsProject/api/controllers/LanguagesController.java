package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.ResumeLanguageService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	@Autowired
	private ResumeLanguageService languageService;
	
	public LanguagesController(ResumeLanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody ResumeLanguage language){
		return this.languageService.add(language);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody ResumeLanguage language){
		return this.languageService.update(language);
		
	}
	
	@PostMapping("/delete")
	public Result delete( @RequestParam int  id){
		return this.languageService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeLanguage>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<ResumeLanguage>> getAllByCandidateId(@RequestParam int id){
		return this.languageService.getAllByJobSeekerId(id);
	}
	/*@GetMapping("/getById")
	public DataResult<ResumeLanguage> getById(@RequestParam int id){
		return this.languageService.getById(id);
	}*/

}
