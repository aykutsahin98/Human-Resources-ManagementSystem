package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.entities.concretes.User;
import hrms.HrmsProject.entities.dtos.UserLoginDto;
import hrms.HrmsProject.entities.dtos.UserLoginReturnDto;

public interface UserService {

	 DataResult<List<User>> getAll();
	 DataResult<User> getByEmail(String email);
	 DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
	 DataResult<List<User>> getVerifyedUsers();
}
