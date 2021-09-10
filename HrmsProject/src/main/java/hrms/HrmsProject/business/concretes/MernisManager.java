package hrms.HrmsProject.business.concretes;

import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.NationalValidationService;
import hrms.HrmsProject.entities.concretes.JobSeeker;

@Service
public class MernisManager implements NationalValidationService {

	@Override
	public boolean validate(JobSeeker candidate) {
		
		 if(candidate.getNationalId().length()!=11){
	            return false;
	        }
	        return true;
	}
}
