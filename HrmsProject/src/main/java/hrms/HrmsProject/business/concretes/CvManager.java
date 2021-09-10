package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.CvService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeImageDao;
import hrms.HrmsProject.entities.concretes.Cv;
import hrms.HrmsProject.entities.concretes.ResumeImage;

@Service
public class CvManager implements CvService {

	  private CvDao cvDao;
	  private JobSeekerDao candidateDao;
	  private ResumeImageDao imageDao;

	    
	  @Autowired
	    public CvManager(CvDao cvDao,JobSeekerDao candidateDao,ResumeImageDao imageDao) {
	        this.cvDao = cvDao;
	        this.candidateDao=candidateDao;
	        this.imageDao=imageDao;
	    }
	  
	@Override
	public Result add(int candidateId) {
		Cv cv=new Cv();
        cv.setCandidate(this.candidateDao.getById(candidateId));

        this.cvDao.save(cv);
        ResumeImage image=new ResumeImage();
        image.setCv(cv);
        image.setUrlAddress("https://res.cloudinary.com/du9huaxi3/image/upload/v1628519372/bosresim_kjihcl.png");
        this.imageDao.save(image);
        return new SuccessResult("Kaydedildi");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		  return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<Cv> getByCvId(int cvId) {
		 if(!this.cvDao.existsById(cvId)){
	            return new ErrorDataResult<Cv>("Böyle bir cv yok");
	        }
	        return new SuccessDataResult<Cv>(this.cvDao.findByCandidateId(cvId),"Data listelendi");
	}

	@Override
	public DataResult<Cv> getByCandidateId(int candidateId) {
		if(this.cvDao.getById(candidateId) == null){
            return new ErrorDataResult<Cv>("Böyle bir candidate yok");
        }
        return new SuccessDataResult<Cv>(this.cvDao.getById(candidateId),"Data listelendi");
	}

	@Override
	public Result updateGithub(String githublink, int cvId) {
		  if(!this.cvDao.existsById(cvId)){
	            return new ErrorResult("Böyle bir cv yok");
	        }else if(!githublink.startsWith("https://github.com")){
	            if(!githublink.startsWith("github.com")){
	                return new ErrorResult("Geçerli bir github linki değil");
	            }
	        }

	        Cv cv=this.cvDao.getById(cvId);
	        cv.setGithub(githublink);
	        this.cvDao.save(cv);
	        return new SuccessResult("Kaydedildi");
	}

	@Override
	public Result deleteGithub(int cvId) {
		 if(!this.cvDao.existsById(cvId)){
	            return new ErrorResult("Böyle bir cv yok");
	        }
	        Cv cv=this.cvDao.getById(cvId);
	        cv.setGithub(null);
	        this.cvDao.save(cv);

	        return new SuccessResult("Github adresi kaldırıldı");
	}

	@Override
	public Result updateLinkedin(String linkedinlink, int cvId) {
		if(!this.cvDao.existsById(cvId)){
            return new ErrorResult("Böyle bir cv yok");
        }else if(!linkedinlink.startsWith("https://www.linkedin.com") &&
                !linkedinlink.startsWith("www.linkedin.com") &&
                !linkedinlink.startsWith("https://linkedin.com") &&
                !linkedinlink.startsWith("linkedin.com")){
            return new ErrorResult("Geçerli bir linked in adresi değil");
        }
        Cv cv=this.cvDao.findByCandidateId(cvId);
        cv.setLinkedin(linkedinlink);
        this.cvDao.save(cv);
        return new SuccessResult("Kaydedildi");
	}

	@Override
	public Result deleteLinkedin(int cvId) {
		 if(!this.cvDao.existsById(cvId)){
	            return new ErrorResult("Böyle bir cv yok");
	        }
	        Cv cv=this.cvDao.getById(cvId);
	        cv.setLinkedin(null);
	        this.cvDao.save(cv);
	        return new SuccessResult("Linkedin adresi silindi");
	}

	@Override
	public Result updateBiography(String biography, int cvId) {
		  if(!this.cvDao.existsById(cvId)){
	            return new ErrorResult("Böyle bir cv yok");
	        }else if(biography.length()<=2){
	            return new ErrorResult("Biyografi 2 krakterden uzun olmalıdır");
	        }
	        Cv cv=this.cvDao.getById(cvId);
	        cv.setBiography(biography);
	        this.cvDao.save(cv);
	        return new SuccessResult("Biyografi kaydedildi");
	}

	@Override
	public Result deleteBiography(int cvId) {
		 if(!this.cvDao.existsById(cvId)){
	            return new ErrorResult("Böyle bir cv yok");
	        }
	        Cv cv=this.cvDao.getById(cvId);
	        cv.setBiography(null);
	        this.cvDao.save(cv);
	        return new SuccessResult("Biyografi silindi");
	}

}
