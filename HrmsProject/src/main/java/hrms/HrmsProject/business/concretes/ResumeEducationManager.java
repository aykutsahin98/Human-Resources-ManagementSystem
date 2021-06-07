package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeEducationService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeEducationDao;
import hrms.HrmsProject.entities.concretes.ResumeEducation;

@Service
public class ResumeEducationManager implements ResumeEducationService {

	private ResumeEducationDao educationDao;
	
	@Autowired
	public ResumeEducationManager(ResumeEducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(ResumeEducation education) {
		this.educationDao.save(education);
		return new SuccessResult("Okul Bilgisi Başarıyla Eklendi!");
	}

	@Override
	public Result update(ResumeEducation education) {
		this.educationDao.save(education);
		return new SuccessResult("Okul Bilgisi Başarıyla Güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("Okul Bilginiz Silinmiştir.");
	}

	@Override
	public DataResult<List<ResumeEducation>> getAll() {
		return new SuccessDataResult<List<ResumeEducation>>(this.educationDao.findAll());
	}

	@Override
	public DataResult<ResumeEducation> getById(int id) {
		return new SuccessDataResult<ResumeEducation>(this.educationDao.getById(id));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByJobseekerIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<ResumeEducation>>(this.educationDao.getAllByCandidate_idOrderByEndedDateDesc(id));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByJobSeekerId(int id) {
	    return new SuccessDataResult<List<ResumeEducation>>(this.educationDao.getAllByCandidate_id(id));
	}
}