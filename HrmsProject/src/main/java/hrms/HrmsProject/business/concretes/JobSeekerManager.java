package hrms.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.*;
import hrms.HrmsProject.core.abstracts.MailCheckService;
import hrms.HrmsProject.core.abstracts.MailSendService;
import hrms.HrmsProject.core.abstracts.MernisCheckService;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.*;
import hrms.HrmsProject.entities.concretes.*;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private MailCheckService emailCheckService;
	private MailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	private List<String> emails = new ArrayList<>();
	private List<String> identificationNumbers = new ArrayList<>();
	
	@Autowired
	public JobSeekerManager(MailCheckService emailCheckService, JobSeekerDao jobSeekerDao, 
			MailSendService emailSendService, 
			MernisCheckService mernisCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public Result login(String email, String password) {
		Result result = new ErrorResult("Giriş Başarısız!");
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getEmail() == email && getAll().get(i).getPassword() == password) {
				result = new SuccessResult("Giriş Başarılı!");
			}
		}
		return result;
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.mailCheck(jobSeeker.getEmail())
				&& emailIsItUsed(jobSeeker.getEmail())
				&& identificationNumberIsItUsed(jobSeeker.getIdentificationNumber())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)) {
			emailSendService.mailSend(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
		}
		return result;
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult("Deletion is successful");
	}

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

	@Override
	public List<String> getAllIdentificationNumber() {
		for (int i = 0; i < getAll().size(); i++) {
			identificationNumbers.add(getAll().get(i).getIdentificationNumber());
		}
		return identificationNumbers;
	}

	public boolean identificationNumberIsItUsed(String identificationNumber) {
		boolean result = true;
		if (getAllIdentificationNumber().contains(identificationNumber)) {
			result = false;
		}
		return result;
	}
	
	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}
}