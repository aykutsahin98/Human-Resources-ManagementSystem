package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.WorkingTypeService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.WorkingType;

@CrossOrigin
@RestController
@RequestMapping("/api/worktypes")
public class WorkingTypesController {

	private WorkingTypeService workingTypeService;
	
	@Autowired
	public WorkingTypesController (WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody WorkingType workingType){
		return this.workingTypeService.add(workingType);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}
	
}
