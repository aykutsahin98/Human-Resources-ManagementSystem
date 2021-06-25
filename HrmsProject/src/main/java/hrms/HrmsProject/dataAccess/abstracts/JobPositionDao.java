package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.entities.concretes.JobPosition;

@Service
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

	JobPosition findByName(String title);
	JobPosition getById(int id);
}
