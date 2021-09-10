package hrms.HrmsProject.business.abstracts;

import hrms.HrmsProject.entities.concretes.JobSeeker;

public interface NationalValidationService {

	boolean validate(JobSeeker candidate);
}
