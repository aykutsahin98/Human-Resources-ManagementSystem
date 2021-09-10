package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.ResumeEducationService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeEducationDao;
import hrms.HrmsProject.entities.concretes.ResumeEducation;
import hrms.HrmsProject.entities.dtos.ResumeEducationDto;

@Service
public class ResumeEducationManager implements ResumeEducationService {

	private ResumeEducationDao educationDao;
	private CvDao cvDao;
	
	@Autowired
	public ResumeEducationManager(ResumeEducationDao educationDao,CvDao cvDao) {
		super();
		this.educationDao = educationDao;
		this.cvDao=cvDao;
	}

	@Override
	public Result addSchool(ResumeEducationDto schoolForSerDto) {
		 if(!this.cvDao.existsById(schoolForSerDto.getCvId())){
	            return new ErrorResult("Böyle bir cv yok");
	        }else if(schoolForSerDto.getSchoolName().length()<=2){
	            return new ErrorResult("Okul adı 2 karakterden uzun olmalıdır");
	        }else if(schoolForSerDto.getDepartment().length()<=2){
	            return new ErrorResult("Bölüm adı 2 karakterden uzun olmalıdır");
	        }else if(schoolForSerDto.getStartedDate()==null){
	            return new ErrorResult("Başlangıç tarihi boş birakılamaz");
	        }

	        ResumeEducation school=new ResumeEducation();
	        school.setCv(this.cvDao.getById(schoolForSerDto.getCvId()));
	        school.setSchoolName(schoolForSerDto.getSchoolName());
	        school.setDepartment(schoolForSerDto.getDepartment());
	        school.setStartedDate(schoolForSerDto.getStartedDate());
	        school.setEndedDate(schoolForSerDto.getEndedDate());

	        this.educationDao.save(school);
	        return new SuccessResult("Okul eklendi");
	}

	@Override
	public Result deleteSchool(int schoolId) {
		 if(!this.educationDao.existsById(schoolId)){
	            return new ErrorResult("Böyle bir okul yok");
	        }
	        this.educationDao.deleteById(schoolId);
	        return new SuccessResult("Okul silindi");
	}

	@Override
	public DataResult<List<ResumeEducation>> getByCvId(int cvId) {
		 if(this.educationDao.findByCvId(cvId)==null){
	            return new ErrorDataResult<List<ResumeEducation>>("Böyle bir cv yok");
	        }
	        return new SuccessDataResult<List<ResumeEducation>>(this.educationDao.findByCvId(cvId),"Data listelendi");
	}

	/*@Override
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
	}*/
}