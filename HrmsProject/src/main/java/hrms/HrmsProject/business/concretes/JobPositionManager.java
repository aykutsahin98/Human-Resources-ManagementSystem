package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.JobPositionService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.HrmsProject.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Tüm iş pozisyonları listelendi.");

	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(getJobByTitle(jobPosition.getName()).getData() != null){
			return new ErrorResult( jobPosition.getName() + "zaten var");
		}
		this.jobPositionDao.save(jobPosition);
	    return new SuccessResult("İş Pozisyonu baaşarılı bir şekilde eklendi!.");
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("İş Pozisyonu Başarıyla Silindi");
	}
	@Override
	public DataResult<JobPosition> getJobByTitle(String title) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByName(title));
	}

	
}
