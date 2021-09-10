package hrms.HrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.ActivationByStaffService;
import hrms.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/acticationbystaff")
@CrossOrigin

public class ActivationStaffController {
	
	private ActivationByStaffService activationByStaffService;
	
	@Autowired
    public ActivationStaffController(ActivationByStaffService activationByStaffService) {
        this.activationByStaffService = activationByStaffService;
    }
	
	@GetMapping("/activateemployer")
    public ResponseEntity<?> activateEmployer(@RequestParam int employerId,@RequestParam int staffId){
        Result result=this.activationByStaffService.activateEmployer(employerId, staffId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
