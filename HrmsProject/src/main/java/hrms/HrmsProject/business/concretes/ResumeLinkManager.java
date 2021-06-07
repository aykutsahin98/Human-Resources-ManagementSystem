package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeLinkService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeLinkDao;
import hrms.HrmsProject.entities.concretes.ResumeLink;

@Service
public class ResumeLinkManager implements ResumeLinkService{

	private ResumeLinkDao resumeLinkDao;

	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
	}
	
	@Override
	public Result add(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link Eklendi!");
	}

	@Override
	public Result update(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link Güncellendi!");
	}

	@Override
	public Result delete(int jobSeekerId) {
		this.resumeLinkDao.deleteById(jobSeekerId);
		return new SuccessResult("Link Silindi!");
	}

	@Override
	public DataResult<List<ResumeLink>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.getAllByCandidate_id(jobSeekerId));
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll());	
	}

	@Override
	public DataResult<ResumeLink> getById(int id) {
		return new SuccessDataResult<ResumeLink>(this.resumeLinkDao.getById(id));
	}

}
