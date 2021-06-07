package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeExperienceService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeExperienceDao;
import hrms.HrmsProject.entities.concretes.ResumeExperience;

@Service
public class ResumeExperienceManager implements ResumeExperienceService{

	private ResumeExperienceDao jobExperienceDao;
	
	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(ResumeExperience resumeExperience) {
		this.jobExperienceDao.save(resumeExperience);
		return new SuccessResult("İş Deneyimi Eklendi");
	}

	@Override
	public Result update(ResumeExperience resumeExperience) {
		this.jobExperienceDao.save(resumeExperience);
		return new SuccessResult("İş Deneyimi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş Deneyimi Silindi");
	}

	@Override
	public DataResult<ResumeExperience> getById(int id) {
		return new SuccessDataResult<ResumeExperience>(this.jobExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<ResumeExperience>> getAll() {
		return new SuccessDataResult<List<ResumeExperience>>(this.jobExperienceDao.findAll());		
	}

	@Override
	public DataResult<List<ResumeExperience>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<ResumeExperience>>(this.jobExperienceDao.getAllByCandidate_id(jobSeekerId));
	}

	@Override
	public DataResult<List<ResumeExperience>> getAllByJobSeekerIdOrderByDesc(int id) {
		return new SuccessDataResult<List<ResumeExperience>>(this.jobExperienceDao.getAllByCandidate_idOrderByEndedDateDesc(id));
	}
	
}