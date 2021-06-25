package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.WorkingType;

public interface WorkingTypeService {

	Result add(WorkingType workingType);
	DataResult<List<WorkingType>> getAll();
}
