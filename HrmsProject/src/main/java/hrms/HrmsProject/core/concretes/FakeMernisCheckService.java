package hrms.HrmsProject.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hrms.HrmsProject.core.abstracts.MernisCheckService;
import hrms.HrmsProject.entities.concretes.JobSeeker;

@Primary
@Component
public class FakeMernisCheckService implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}
}
