package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeLanguageService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeLanguageDao;
import hrms.HrmsProject.entities.concretes.ResumeLanguage;
import hrms.HrmsProject.entities.dtos.ResumeLanguageDto;

@Service
public class ResumeLanguageManager implements ResumeLanguageService{

	private ResumeLanguageDao languageDao;
	 private CvDao cvDao;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao languageDao,CvDao cvDao) {
		super();
		this.languageDao = languageDao;
		this.cvDao = cvDao;
	}

	@Override
	public Result addLanguage(ResumeLanguageDto resumeLanguageDto) {
		 if(!this.cvDao.existsById(resumeLanguageDto.getCvId())){
	            return new ErrorResult("Böyle bir cv yok");
	        }else if(resumeLanguageDto.getLanguageName().length()<=2){
	            return new ErrorResult("Dil ismi 2 karakterden uzun olmalıdır");
	        }else if(Integer.parseInt(resumeLanguageDto.getLevel()) <=0 || Integer.parseInt(resumeLanguageDto.getLevel()) >=6){
	            return new ErrorResult("Dil seviyesi 1-5 arası bir değer olmalıdır");
	        }

	        ResumeLanguage language=new ResumeLanguage();
	        language.setCv(this.cvDao.getById(resumeLanguageDto.getCvId()));
	        language.setLanguageName(resumeLanguageDto.getLanguageName());
	        language.setLevel(resumeLanguageDto.getLevel());

	        this.languageDao.save(language);
	        return new SuccessResult("Dil kaydedildi");
	}

	@Override
	public Result deleteLanguage(int languageId) {
		if(!this.languageDao.existsById(languageId)){
            return new ErrorResult("Böyle bir dil bulunamadı");
        }
        this.languageDao.deleteById(languageId);
        return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<ResumeLanguage>> getByCvId(int cvId) {
		 if(!this.cvDao.existsById(cvId)){
	            return new ErrorDataResult<List<ResumeLanguage>>("Böyle bir cv yok");
	        }
	        return new SuccessDataResult<List<ResumeLanguage>>(this.languageDao.findByCvId(cvId),"Listelendi");
	}
}

	/*@Override
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
	}*/
	