package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.HrmsProject.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findCandidateByNationalId(String nationalId);
	JobSeeker getById(int id);
}
