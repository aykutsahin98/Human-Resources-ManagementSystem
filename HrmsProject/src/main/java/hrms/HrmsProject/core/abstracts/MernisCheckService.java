package hrms.HrmsProject.core.abstracts;

import org.springframework.stereotype.Service;

import hrms.HrmsProject.entities.concretes.JobSeeker;

@Service
public interface MernisCheckService {

	public boolean checkIfRealPerson(JobSeeker jobSeeker);
}
