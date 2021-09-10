package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.JobSeeker;
import hrms.HrmsProject.entities.dtos.JobSeekerRegisterDto;
import hrms.HrmsProject.entities.dtos.JobSeekerResumeDto;

public interface JobSeekerService{
		
	//Result add(JobSeeker candidate);
	Result update(JobSeeker candidate );
	Result delete(int id);
	DataResult<JobSeeker> getById(int id);	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getCandidateByNationalId(String nationalId);
	//DataResult<JobSeekerResumeDto> getCandidateCVById(int id);
	Result add(JobSeekerRegisterDto candidateForRegisterDto);
}
