package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeEducation;
import hrms.HrmsProject.entities.dtos.ResumeEducationDto;

public interface ResumeEducationService {

	/*Result add (ResumeEducation education);	
	Result update(ResumeEducation education);
	Result delete(int id);
	DataResult<List<ResumeEducation>> getAll();
	DataResult<ResumeEducation> getById(int id);
	DataResult<List<ResumeEducation>> getAllByJobseekerIdOrderByEndedDateDesc(int id);
	DataResult<List<ResumeEducation>> getAllByJobSeekerId(int id);*/
	
	 public Result addSchool(ResumeEducationDto schoolForSerDto);
	 public Result deleteSchool(int schoolId);
	 public DataResult<List<ResumeEducation>> getByCvId(int cvId);
}
