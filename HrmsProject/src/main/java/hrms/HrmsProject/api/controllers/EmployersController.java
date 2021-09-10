package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.EmployerService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Employer;
import hrms.HrmsProject.entities.concretes.EmployerUpdate;
import hrms.HrmsProject.entities.dtos.EmployerRegisterDto;

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
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }
	
	/*@PostMapping("/register")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.register(employer);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Employer employer) {
		return this.employerService.delete(employer);
		
	}*/
	
	 @PostMapping("/add")
	    public ResponseEntity<?> add(@RequestBody EmployerRegisterDto employerForRegisterDto){
	        Result result=this.employerService.add(employerForRegisterDto);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }
	 
	 @GetMapping("/getById")
	    DataResult<Employer> getById(@RequestParam int id){
	        return this.employerService.getById(id);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<?> update(@RequestBody EmployerUpdate employerUpdate){
	        Result result = this.employerService.update(employerUpdate);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }
	 
	 @PutMapping("/verifyUpdate")
	    public ResponseEntity<?> verifyUpdate(@RequestParam int employerUpdateId,@RequestParam int staffId){
	        Result result = this.employerService.verifyUpdate(employerUpdateId,staffId);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }
	        return ResponseEntity.badRequest().body(result);
	    }
	
}