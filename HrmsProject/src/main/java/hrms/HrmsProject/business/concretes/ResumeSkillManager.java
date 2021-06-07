package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeSkillService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeSkillDao;
import hrms.HrmsProject.entities.concretes.ResumeSkill;

@Service
public class ResumeSkillManager implements ResumeSkillService {

	private ResumeSkillDao resumeSkillDao;
	
	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
	}

	
	@Override
	public Result add(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("Yetenek Bilgisi Başarıyla Eklenmiştir");
	}

	@Override
	public Result update(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("Yetenek Bilgileriniz Güncellenmiştir!");
	}

	@Override
	public Result delete(int jobSeekerId) {
		this.resumeSkillDao.deleteById(jobSeekerId);
		return new SuccessResult("Yetenek Bilgileriniz Silindi!");
	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.getAllByCandidate_id(jobSeekerId));
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll());
		
	}
	
	@Override
	public DataResult<ResumeSkill> getById(int id) {
		return new SuccessDataResult<ResumeSkill>(this.resumeSkillDao.getById(id));
	}

}
