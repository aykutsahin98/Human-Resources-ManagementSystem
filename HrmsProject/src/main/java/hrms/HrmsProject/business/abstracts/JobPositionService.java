package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAll();
	public Result add(JobPosition jobPosition);
	public Result delete(JobPosition jobPosition);
}
