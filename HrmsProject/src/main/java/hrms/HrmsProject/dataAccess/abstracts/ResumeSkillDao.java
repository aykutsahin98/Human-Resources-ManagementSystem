package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ResumeSkill;

public interface ResumeSkillDao extends JpaRepository<ResumeSkill, Integer>{

	/*ResumeSkill getById(int id);
	List<ResumeSkill> getAllByCandidate_id(int id);*/
	List<ResumeSkill> findByCvId(int id);
}
