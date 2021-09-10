package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Employer;
import hrms.HrmsProject.entities.concretes.EmployerUpdate;
import hrms.HrmsProject.entities.dtos.EmployerRegisterDto;

public interface EmployerService {

	 	DataResult<List<Employer>> getAll();
	    DataResult<Employer> getByEmail(String email);
	    Result add(EmployerRegisterDto employerDto);
	    DataResult<Employer> getById(int id);
	    Result update(EmployerUpdate employerUpdate);
	    Result verifyUpdate(int employerUpdateId,int staffId);
	

}
