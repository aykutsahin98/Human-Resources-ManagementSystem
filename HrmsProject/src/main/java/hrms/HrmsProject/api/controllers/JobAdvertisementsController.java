package hrms.HrmsProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.JobAdvertisementService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobAdvertisement;
import hrms.HrmsProject.entities.dtos.JobAdvertisementDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/sortbyreleasedate")
	public DataResult<List<JobAdvertisement>> sortByReleaseDate() {
		return this.jobAdvertisementService.sortByReleaseDate();
	}
	
	@GetMapping("/getbyisconfirm")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isConfirm) {
		return this.jobAdvertisementService.getByIsConfirm(isConfirm);
	}
	
	@GetMapping("/getbyisconfirmandisactive")
	public DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(@RequestParam boolean isConfirm,
			@RequestParam boolean isActive) {
		return this.jobAdvertisementService.getByIsConfirmAndIsActive(isConfirm, isActive);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@PostMapping("/updateisactive")
	public Result updateIsActive(@RequestParam boolean isActive, @RequestParam int userId, @RequestParam int id) {
		return this.jobAdvertisementService.updateIsActive(isActive, userId, id);
	}

	@PostMapping("/updateisconfirm")
	public Result updateIsConfirm(@RequestParam boolean isConfirm, @RequestParam int id) {
		return this.jobAdvertisementService.updateIsConfirm(isConfirm, id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getById(@RequestParam int id) {
		return this.jobAdvertisementService.getById(id);
	}

}