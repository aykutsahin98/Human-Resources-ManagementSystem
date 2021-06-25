package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobAdvertisement;
import hrms.HrmsProject.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByIsConfirm(boolean isConfirm);
	
	DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	Result add(JobAdvertisementDto jobAdvertisementDto);

	Result updateIsConfirm(boolean isConfirm, int id);

	Result updateIsActive(boolean isActive, int userId, int id);
	
	DataResult<List<JobAdvertisement>> sortByReleaseDate();

	DataResult<JobAdvertisement> getById(int id);
}
