package hrms.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.HrmsProject.business.abstracts.UserService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.entities.concretes.User;
import hrms.HrmsProject.entities.dtos.UserLoginDto;
import hrms.HrmsProject.entities.dtos.UserLoginReturnDto;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {
	 private UserService userService;
	 
	 @Autowired
	    public UsersController(UserService userService) {
	        this.userService = userService;
	    }
	 
	 @GetMapping("/getall")
	    public DataResult<List<User>> getAll(){
	        return this.userService.getAll();
	    }
	 
	 @PostMapping("/login")
	    ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto){
	        DataResult<UserLoginReturnDto> result = this.userService.login(userLoginDto);
	        if(result.isSuccess()){
	            return ResponseEntity.ok(result);
	        }else {
	            return ResponseEntity.badRequest().body(result);
	        }
	    }
	 
	 @GetMapping("/getVerifyedUsers")
	    DataResult<List<User>> getVerifyedUsers(){
	        return this.userService.getVerifyedUsers();
	 }
}
