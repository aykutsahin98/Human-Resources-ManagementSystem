package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeCoverLetterService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeCoverLetterDao;
import hrms.HrmsProject.entities.concretes.ResumeCoverLetter;
import hrms.HrmsProject.entities.concretes.ResumeEducation;
import hrms.HrmsProject.entities.concretes.ResumeSkill;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService {

	private ResumeCoverLetterDao coverLetterDao;
	
	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}
	
	@Override
	public Result add(ResumeCoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön Yazı Sisteme Eklendi!.");
	}

	@Override
	public Result update(ResumeCoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön Yazınızı Güncellendi!.");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Ön Yazınız Silindi!.");
	}

	@Override
	public DataResult<ResumeCoverLetter> getById(int id) {
		return new SuccessDataResult<ResumeCoverLetter>(this.coverLetterDao.findById(id).get());
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAll() {
		return new SuccessDataResult<List<ResumeCoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAllByJobSeekerId(int id) {
		 return new SuccessDataResult<List<ResumeCoverLetter>>(this.coverLetterDao.getAllByCandidate_id(id));
	}

	
}