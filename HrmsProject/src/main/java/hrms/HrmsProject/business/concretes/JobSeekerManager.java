package hrms.HrmsProject.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.*;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.*;
import hrms.HrmsProject.entities.concretes.*;
import hrms.HrmsProject.entities.dtos.JobSeekerRegisterDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private ActivationCodeService activationCodeService;
	private EmailService emailService;
	private NationalValidationService nationalValidationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService,
			ActivationCodeService activationCodeService, EmailService emailService,
			NationalValidationService nationalValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.activationCodeService = activationCodeService;
		this.emailService = emailService;
		this.nationalValidationService = nationalValidationService;
	}

	/*@Override
	public Result add(JobSeeker candidate) {
		this.jobSeekerDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde eklendi!");
	}*/

	@Override
	public Result update(JobSeeker candidate) {
		this.jobSeekerDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("İş adayı başarılı bir şekilde silindi!");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findCandidateByNationalId(nationalId));
	}

	@Override
	public Result add(JobSeekerRegisterDto candidateForRegisterDto) {
		JobSeeker candidate=new JobSeeker();
        candidate.setFirstName(candidateForRegisterDto.getFirstName());
        candidate.setLastName(candidateForRegisterDto.getLastName());
        candidate.setNationalId(candidateForRegisterDto.getNationalId());
        candidate.setBirthYear(candidateForRegisterDto.getBirthYear());
        candidate.setEmail(candidateForRegisterDto.getEmail());
        candidate.setPassword(candidateForRegisterDto.getPassword());
        

        if(candidate.getPassword().length() <=6){
            return new ErrorResult("Şifre 6 karakterden uzun olmalıdır");
        }else if(!isEmailValid(candidate.getEmail())){
            return new ErrorResult("Email geçerli formatta değil");
        }else if(getCandidateByNationalId(candidate.getNationalId()).getData() != null){
            return new ErrorResult("Bu kimlik numarası zaten kayıtlı");
        }else if(userService.getByEmail(candidate.getEmail()).getData() != null){
            return new ErrorResult("Bu email zaten kayıtlı");
        }else if(nationalValidationService.validate(candidate)){
            candidate.setMailVerify(false);
            this.jobSeekerDao.save(candidate);
            this.emailService.sendVerifyEmail(candidate,this.activationCodeService.createActivationCode(candidate));
            return new SuccessResult(candidate.getEmail()+" Adresine doğrulama kodu gönderildi");
        }else{
            return new ErrorResult("Kullanıcı kimlik bilgileri hatalı");
        }
	}
	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }

	/*@Override
	public DataResult<JobSeekerResumeDto> getCandidateCVById(int id) {
		JobSeekerResumeDto resume = new JobSeekerResumeDto();
		resume.jobExperiences = this.jobExperienceService.getAllByJobSeekerId(id).getData();
		resume.languages = this.languageService.getAllByJobSeekerId(id).getData();
		resume.image = this.resumeImageService.getByJobSeekerId(id).getData();
		resume.resumeLinks = this.resumeLinkService.getAllByJobSeekerId(id).getData();
		resume.educations = this.educationService.getAllByJobSeekerId(id).getData();
		resume.resumeSkills = this.resumeSkillService.getAllByJobSeekerId(id).getData();
		return new SuccessDataResult<JobSeekerResumeDto>(resume);
	}*/
	
}