package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ResumeLink;

public interface ResumeLinkDao extends JpaRepository<ResumeLink, Integer> {
	
	ResumeLink getById(int id);
	List<ResumeLink> getAllByCandidate_id(int id);

}
