package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ResumeLanguage;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer>{

	/*ResumeLanguage getById(int id);
	List<ResumeLanguage> getAllByCandidate_id(int id);*/
	   List<ResumeLanguage> findByCvId(int id);
}
