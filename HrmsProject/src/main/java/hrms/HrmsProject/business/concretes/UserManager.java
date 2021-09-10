package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.UserService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeImageDao;
import hrms.HrmsProject.dataAccess.abstracts.SystemPersonnelDao;
import hrms.HrmsProject.dataAccess.abstracts.UserDao;
import hrms.HrmsProject.entities.concretes.User;
import hrms.HrmsProject.entities.dtos.UserLoginDto;
import hrms.HrmsProject.entities.dtos.UserLoginReturnDto;

@Service
public class UserManager implements UserService{
	
	 private UserDao userDao;
	 private JobSeekerDao candidateDao;
	 private EmployerDao employerDao;
	 private SystemPersonnelDao personnelDao;
	 private ResumeImageDao imageDao;


	@Autowired
	public UserManager(UserDao userDao, JobSeekerDao candidateDao, EmployerDao employerDao,
			SystemPersonnelDao personnelDao, ResumeImageDao imageDao) {
		this.userDao = userDao;
		this.candidateDao = candidateDao;
		this.employerDao = employerDao;
		this.personnelDao = personnelDao;
		this.imageDao = imageDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Listelendi");
	}

	@Override
	public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
		 User user = this.userDao.findByEmail(userLoginDto.getEmail());
	        if(user==null){
	            return new ErrorDataResult<UserLoginReturnDto>("Hatalı email girdiniz");
	        }else if(!user.getPassword().equals(userLoginDto.getPassword())){
	            return new ErrorDataResult<UserLoginReturnDto>("Hatalı şifre girdiniz");
	        }
	        UserLoginReturnDto userLoginReturnDto = new UserLoginReturnDto();
	        userLoginReturnDto.setId(user.getId());
	        userLoginReturnDto.setEmail(user.getEmail());
	        

	        if(this.candidateDao.existsById(user.getId())){
	            userLoginReturnDto.setUserType(1);
	            userLoginReturnDto.setName(this.candidateDao.getById(user.getId()).getFirstName()+" "+this.candidateDao.getById(user.getId()).getLastName());
	            userLoginReturnDto.setImage(this.imageDao.findByCvId(user.getId()).getUrlAddress());
	            	
	            
	        }else if(this.employerDao.existsById(user.getId())){
	            userLoginReturnDto.setUserType(2);
	            userLoginReturnDto.setName(this.employerDao.getById(user.getId()).getCompanyName());
	            
	        }else if(this.personnelDao.existsById(user.getId())){
	            userLoginReturnDto.setUserType(3);
	            userLoginReturnDto.setName(this.personnelDao.getOne(user.getId()).getFirstName()+" "+this.personnelDao.getOne(user.getId()).getLastName());
	            
	        }else {
	            return new ErrorDataResult<UserLoginReturnDto>("Bir hata oluştu");
	        }

	        return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto,"Giriş yapıldı");
	}

	@Override
	public DataResult<List<User>> getVerifyedUsers() {
		return new SuccessDataResult<List<User>>(this.userDao.findByMailVerifyTrue(),"Data listelendi");
	}

}
