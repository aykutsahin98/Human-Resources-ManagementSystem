package hrms.HrmsProject.business.abstracts;

import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Employer;

public interface ActivationByStaffService {
	
	void createActivationByStaff(Employer employer);
    Result activateEmployer(int employerId,int staffId);
}
