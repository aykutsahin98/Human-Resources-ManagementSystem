package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeSkillService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeSkillDao;
import hrms.HrmsProject.entities.concretes.ResumeSkill;
import hrms.HrmsProject.entities.dtos.ResumeSkillDto;

@Service
public class ResumeSkillManager implements ResumeSkillService {

	private ResumeSkillDao resumeSkillDao;
	private CvDao cvDao;
	
	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao, CvDao cvDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
		this.cvDao = cvDao;
	}

	@Override
	public Result add(ResumeSkillDto resumeSkillDto) {
		
		if(!this.cvDao.existsById(resumeSkillDto.getCvId())) {
			return new  ErrorResult("Böyle bir Cv yok");
		}else if(resumeSkillDto.getSkillsName().length()<=2) {
			return new ErrorResult("Yetenek adı 2 karakterden az olamaz");
		}
		
		ResumeSkill skills = new ResumeSkill();
		skills.setCv(this.cvDao.getById(resumeSkillDto.getCvId()));
		skills.setSkillsName(resumeSkillDto.getSkillsName());
		
		this.resumeSkillDao.save(skills);
		return new  SuccessResult("Eklendi");
		
	}

	@Override
	public Result delete(int skillsId) {
		 if(!this.resumeSkillDao.existsById(skillsId)){
	            return new ErrorResult("Böyle bir teknoloji yok");
	        }
	        this.resumeSkillDao.deleteById(skillsId);
	        return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<ResumeSkill>> getByCvId(int cvId) {
		if(!this.cvDao.existsById(cvId)){
            return new ErrorDataResult<List<ResumeSkill>>("Böyle bir cv yok");
        }

        return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findByCvId(cvId),"Data listelendi");
	}

	
	/*@Override
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
	}*/

}
