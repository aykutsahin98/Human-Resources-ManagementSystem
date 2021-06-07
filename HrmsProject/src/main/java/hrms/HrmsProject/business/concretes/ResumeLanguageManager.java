package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeLanguageService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeLanguageDao;
import hrms.HrmsProject.entities.concretes.ResumeLanguage;

@Service
public class ResumeLanguageManager implements ResumeLanguageService{

	private ResumeLanguageDao languageDao;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(ResumeLanguage language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı Dil Eklendi");
	}

	@Override
	public Result update(ResumeLanguage language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı Dil Bilgileriniz Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("Yabancı Dil Bilgisi Silindi");
	}

	@Override
	public DataResult<ResumeLanguage> getById(int id) {
		return new SuccessDataResult<ResumeLanguage>(this.languageDao.getById(id));
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccessDataResult<List<ResumeLanguage>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<ResumeLanguage>>(this.languageDao.getAllByCandidate_id(id));
	}
	
}