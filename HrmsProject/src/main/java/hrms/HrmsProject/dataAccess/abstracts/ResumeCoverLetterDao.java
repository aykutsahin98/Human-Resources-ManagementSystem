package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import hrms.HrmsProject.entities.concretes.ResumeCoverLetter;
import hrms.HrmsProject.entities.concretes.ResumeEducation;

public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter, Integer> {

	ResumeCoverLetter getById(int id);
	List<ResumeCoverLetter> getAllByCandidate_id(int id);
}
