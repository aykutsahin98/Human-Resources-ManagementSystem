package hrms.HrmsProject.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import hrms.HrmsProject.business.abstracts.ActivationByStaffService;
import hrms.HrmsProject.business.abstracts.ActivationCodeService;
import hrms.HrmsProject.business.abstracts.EmailService;
import hrms.HrmsProject.business.abstracts.EmployerService;
import hrms.HrmsProject.business.abstracts.UserService;
import hrms.HrmsProject.core.abstracts.MailSendService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.HrmsProject.dataAccess.abstracts.EmployerUpdateDao;
import hrms.HrmsProject.dataAccess.abstracts.SystemPersonnelDao;
import hrms.HrmsProject.entities.concretes.Employer;
import hrms.HrmsProject.entities.concretes.EmployerUpdate;
import hrms.HrmsProject.entities.dtos.EmployerRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	 private EmployerDao employerDao;
	 private UserService userService;
	 private ActivationByStaffService activationByStaffService;
	 private EmployerUpdateDao employerUpdateDao;
	 private SystemPersonnelDao staffDao;
	 private EmailService emailService;
	 private ActivationCodeService activationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService,
			ActivationByStaffService activationByStaffService, EmployerUpdateDao employerUpdateDao,
			SystemPersonnelDao staffDao, EmailService emailService, ActivationCodeService activationCodeService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.activationByStaffService = activationByStaffService;
		this.employerUpdateDao = employerUpdateDao;
		this.staffDao = staffDao;
		this.emailService = emailService;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		 return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email),"Listelendi");
	}

	@Override
	public Result add(EmployerRegisterDto employerDto) {
	
	        Employer employer=new Employer();
	        employer.setEmail(employerDto.getEmail());
	        employer.setPassword(employerDto.getPassword());
	        employer.setCompanyName(employerDto.getCompanyName());
	        employer.setWebSite(employerDto.getWebSite());
	        employer.setPhoneNumber(employerDto.getPhoneNumber());
	        employer.setWaitingUpdate(false);


	       if(userService.getByEmail(employer.getEmail()).getData() != null){
	            return new ErrorResult("Bu email zaten kayıtlı");
	       }else if(!isEmailValid(employer.getEmail())){
	           return new ErrorResult("Geçerli bir email giriniz");
	       }else if(employer.getPassword().length() <=6 ){
	           return new ErrorResult("Şifre 6 karakterden uzun olmalıdır.");
	       }else if(employer.getPhoneNumber().length() <10){
	           return new ErrorResult("Geçerli bir telefon numarası giriniz.");
	       }else if(employer.getCompanyName().length()<=2){
	           return new ErrorResult("Şirket adı 2 karakterden uzun olmalıdır");
	       }

	       employer.setVerificationStatus(false);
	       this.employerDao.save(employer);

	       this.emailService.sendVerifyEmail(employer,this.activationCodeService.createActivationCode(employer));
	       activationByStaffService.createActivationByStaff(employer);



	       return new SuccessResult(employer.getEmail()+" Adresine doğrulama kodunuz gönderildi");

	}

	@Override
	public DataResult<Employer> getById(int id) {
		 if(!this.employerDao.existsById(id)){
	            return new ErrorDataResult<Employer>("Böyle bir işveren yok");
	        }
	        return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Data listelendi");
	}

	@Override
	public Result update(EmployerUpdate employerUpdate) {
		employerUpdate.setId(0);
        employerUpdate.setCreateDay(LocalDate.now());
        employerUpdate.setStaffId(16);

        if(employerUpdate.getEmployerId() == null){
            return new ErrorResult("İş veren id boş birakılamaz");
        }else if(employerUpdate.getEmail()==null){
            return new ErrorResult("Email boş bırakılamaz");
        }else if(employerUpdate.getCompanyName()==null){
            return new ErrorResult("Şirket adı boş bırakılamaz");
        }else if(employerUpdate.getPhoneNumber()==null){
            return new ErrorResult("Telefon numarası boş bırakılamaz");
        }else if(employerUpdate.getWebSite()==null){
            return new ErrorResult("Web sitesi boş bırakılamaz");
        }else if(employerUpdate.getCompanyName().length()<2){
            return new ErrorResult("Şirket adı 2 karakterden kısa olamaz");
        }else if(employerUpdate.getPhoneNumber().length()!=10){
            return new ErrorResult("Telefon numarası 11 haneli olmalıdır");
        }else if(!isEmailValid(employerUpdate.getEmail())){
            return new ErrorResult("Geçerli bir mail adresi giriniz");
        }else if(!this.employerDao.existsById(employerUpdate.getEmployerId())){
            return new ErrorResult(("Böyle bir işveren yok"));
        }
        Employer employer=this.employerDao.getById(employerUpdate.getEmployerId());
        this.employerUpdateDao.save(employerUpdate);
        employer.setWaitingUpdate(true);
        this.employerDao.save(employer);
        return new SuccessResult("Güncelleme isteği gönderildi personelin onayı ardından görünür olacaktır");
	}

	@Override
	public Result verifyUpdate(int employerUpdateId, int staffId) {
		 if(!this.employerUpdateDao.existsById(employerUpdateId)){
	            return new ErrorResult("Böyle bir güncelleme talebi yok");
	        }else if(!this.staffDao.existsById(staffId)){
	            return new ErrorResult("Böyle bir personel yok");
	        }
	        EmployerUpdate employerUpdate=this.employerUpdateDao.getById(employerUpdateId);
	        Employer employer=this.employerDao.getById(employerUpdate.getEmployerId());

	        employerUpdate.setVerifyed(true);
	        employerUpdate.setStaffId(staffId);
	        employerUpdate.setVerifyDate(LocalDate.now());
	        this.employerUpdateDao.save(employerUpdate);

	        employer.setEmail(employerUpdate.getEmail());
	        employer.setCompanyName(employerUpdate.getCompanyName());
	        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
	        employer.setWebSite(employerUpdate.getWebSite());
	        employer.setWaitingUpdate(false);
	        this.employerDao.save(employer);
	        return new SuccessResult("Bilgiler güncellendi");
	}
	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
	
}
	/*private EmployerDao employerDao;
	private MailSendService emailSendService;
	private List<String> emails = new ArrayList<String>();

	@Autowired
	public EmployerManager(EmployerDao employerDao, MailSendService emailSendService) {
		super();
		this.employerDao = employerDao;
		this.emailSendService=emailSendService;		
	}
	
	@Override
	public Result login(String email, String password) {
		Result result= new ErrorResult("Giriş Başarısız!");
		for (int i = 0; i < getAll().size(); i++) {
			if(getAll().get(i).getEmail()==email && getAll().get(i).getPassword()==password) {
				result = new SuccessResult("Giriş Başarılı!");
			}
		}
		return result;
	}

	@Override
	public Result register(Employer employer) {
		Result result=new ErrorResult("Kayıt Başarısız!");
		if(emailIsItUsed(employer.getEmail())) {
			emailSendService.mailSend(employer.getEmail());
			employer.setVerificationStatus(false); //default 
			this.employerDao.save(employer);
			result = new SuccessResult("Kayıt Başarılı!");
		}
		return result;
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("Başarıyla Silindi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		 return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi");
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if(getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}*/
