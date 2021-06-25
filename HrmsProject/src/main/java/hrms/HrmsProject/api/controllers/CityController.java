package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.CityService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.entities.concretes.City;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CityController {
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	
	@GetMapping("/getall")
	
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
