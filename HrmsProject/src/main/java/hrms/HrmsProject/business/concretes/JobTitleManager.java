package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.JobTitleService;
import hrms.HrmsProject.dataAccess.abstracts.JobTittleDao;
import hrms.HrmsProject.entities.concretes.JobTittle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTittleDao jobTittleDao;

	@Autowired
	public JobTitleManager(JobTittleDao jobTittleDao) {
		this.jobTittleDao  = jobTittleDao;
	}

	@Override
	public List<JobTittle> getAll() {
		return jobTittleDao.findAll();
	}

}
