package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeExperience;
import hrms.HrmsProject.entities.dtos.ResumeExperinceDto;

public interface ResumeExperienceService {

	/*Result add(ResumeExperience resumeExperience);
	Result update(ResumeExperience resumeExperience);
	Result delete(int id);
	DataResult<ResumeExperience> getById(int id);
	DataResult<List<ResumeExperience>> getAll();
	DataResult<List<ResumeExperience>> getAllByJobSeekerId(int jobSeekerId);
	DataResult<List<ResumeExperience>>  getAllByJobSeekerIdOrderByDesc(int id);*/
	
	 Result add(ResumeExperinceDto experianceForSetDto);
	 Result delete(int experianceId);
	 DataResult<List<ResumeExperience>> getByCvId(int id);
}
