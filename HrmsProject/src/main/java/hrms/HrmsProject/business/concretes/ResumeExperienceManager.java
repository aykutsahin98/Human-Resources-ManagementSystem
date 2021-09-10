package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeExperienceService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeExperienceDao;
import hrms.HrmsProject.entities.concretes.ResumeExperience;
import hrms.HrmsProject.entities.dtos.ResumeExperinceDto;

@Service
public class ResumeExperienceManager implements ResumeExperienceService{

	private ResumeExperienceDao experinceDao;
	private CvDao cvDao;

	
	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao experinceDao,CvDao cvDao) {
		super();
		this.experinceDao = experinceDao;
		this.cvDao=cvDao;
	}

	@Override
	public Result add(ResumeExperinceDto experianceForSetDto) {
		  if(!this.cvDao.existsById(experianceForSetDto.getCvId())){
	            return new ErrorResult("Böyle bir cv yok");
	        }else if(experianceForSetDto.getWorkspaceName().length()<=2){
	            return new ErrorResult("Şirket adı 2 karakterden uzun olmalıdır");
	        }else if(experianceForSetDto.getPosition().length()<=2){
	            return new ErrorResult("Pozisyon adı 2 karakterden uzun olmalıdır");
	        }else if(experianceForSetDto.getStartedDate() == null){
	            return new ErrorResult("Başlangıç tarihi boş bırakılamaz");
	        }

	        ResumeExperience experiance=new ResumeExperience();
	        experiance.setCv(this.cvDao.getById(experianceForSetDto.getCvId()));
	        experiance.setWorkspaceName(experianceForSetDto.getWorkspaceName());
	        experiance.setPosition(experianceForSetDto.getPosition());
	        experiance.setStartedDate(experianceForSetDto.getStartedDate());
	        experiance.setEndedDate(experianceForSetDto.getEndedDate());

	        this.experinceDao.save(experiance);
	        return new SuccessResult("Kaydedildi");
	}

	@Override
	public Result delete(int experianceId) {
		  if(!this.experinceDao.existsById(experianceId)){
	            return new ErrorResult("Böyle bir tecrübe yok");
	        }
	        this.experinceDao.deleteById(experianceId);
	        return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<ResumeExperience>> getByCvId(int id) {
		return new SuccessDataResult<List<ResumeExperience>>(this.experinceDao.findByCvId(id),"Data listelendi");
	}

	/*@Override
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
	}*/
	
}