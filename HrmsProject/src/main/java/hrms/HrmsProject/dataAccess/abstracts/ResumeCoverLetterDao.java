package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import hrms.HrmsProject.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter, Integer> {

	ResumeCoverLetter getById(int id);
}
