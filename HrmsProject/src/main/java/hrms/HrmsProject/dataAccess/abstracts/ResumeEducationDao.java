package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.HrmsProject.entities.concretes.ResumeEducation;


public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer>{

	/*ResumeEducation getById(int id);
	
	List<ResumeEducation> getAllByCandidate_id(int id);*/
	//List<ResumeEducation> getAllByCandidate_idOrderByEndedDateDesc(int id);
	 List<ResumeEducation> findByCvId(int id);
	
}
