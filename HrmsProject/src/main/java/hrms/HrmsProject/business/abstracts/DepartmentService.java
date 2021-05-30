package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Department;

public interface DepartmentService {

	public DataResult<List<Department>> getAll();
	public Result add(Department department);
	public Result delete(Department department);
}
