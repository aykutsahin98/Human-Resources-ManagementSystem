package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {

	public DataResult<List<SystemPersonnel>> getAll();
	public Result delete(SystemPersonnel systemPersonnel);	
	public Result register(SystemPersonnel systemPersonnel);
}
