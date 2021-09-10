package hrms.HrmsProject.business.concretes;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ActivationByStaffService;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ActivationByPersonnelDao;
import hrms.HrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.HrmsProject.entities.concretes.ActivationByPersonnel;
import hrms.HrmsProject.entities.concretes.Employer;

@Service
public class ActivationByStaffManager implements ActivationByStaffService {

	private ActivationByPersonnelDao activationByStaffDao;
    private EmployerDao employerDao;
    
    @Autowired
    public ActivationByStaffManager(ActivationByPersonnelDao activationByStaffDao,EmployerDao employerDao) {
        this.activationByStaffDao = activationByStaffDao;
        this.employerDao=employerDao;
    }
    
	@Override
	public void createActivationByStaff(Employer employer) {
		 ActivationByPersonnel activationByStaff=new ActivationByPersonnel();
	     activationByStaff.setEmployeId(employer.getId());
	     activationByStaff.setVerifyed(false);
	     activationByStaff.setStaffId(null);
	     activationByStaffDao.save(activationByStaff);	
	}

	@Override
	public Result activateEmployer(int employerId, int staffId) {
		 try {
	            Employer employer = employerDao.getById(employerId);
	            ActivationByPersonnel activationByStaff = activationByStaffDao.findByEmployeId(employerId);

	            employer.setVerificationStatus(true);
	            employerDao.save(employer);

	            activationByStaff.setVerifyed(true);
	            activationByStaff.setVerifyDate(LocalDate.now());
	            activationByStaff.setStaffId(staffId);
	            activationByStaffDao.save(activationByStaff);

	        }catch (EntityNotFoundException exception){
	            return new ErrorResult("Hatalı id");
	        }
	        return new SuccessResult("Kullanıcı aktif edildi");
	    }
	}
