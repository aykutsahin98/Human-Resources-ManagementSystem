package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeSkill;
import hrms.HrmsProject.entities.dtos.ResumeSkillDto;

public interface ResumeSkillService {

	public Result add(ResumeSkillDto resumeSkillDto);
	//public Result update(ResumeSkill resumeSkill);
	public Result delete(int skillsId);
	public DataResult<List<ResumeSkill>> getByCvId(int cvId);	
	/*DataResult<List<ResumeSkill>> getAllByJobSeekerId(int id);
	DataResult<List<ResumeSkill>> getAll();*/
}
