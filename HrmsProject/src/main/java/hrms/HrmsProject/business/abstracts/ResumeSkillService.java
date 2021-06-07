package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeSkill;

public interface ResumeSkillService {

	Result add(ResumeSkill resumeSkill);
	Result update(ResumeSkill resumeSkill);
	Result delete(int id);
	DataResult<ResumeSkill> getById(int id);	
	DataResult<List<ResumeSkill>> getAllByJobSeekerId(int id);
	DataResult<List<ResumeSkill>> getAll();
}
