package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.HrmsProject.entities.concretes.ResumeExperience;

public interface ResumeExperienceDao extends JpaRepository<ResumeExperience, Integer>{

	//ResumeExperience getById(int id);
	//List<ResumeExperience> getAllByCandidate_idOrderByEndedDateDesc(int id);
	//List<ResumeExperience> getAllByCandidate_id(int id);
	List<ResumeExperience> findByCvId(int id);
}
