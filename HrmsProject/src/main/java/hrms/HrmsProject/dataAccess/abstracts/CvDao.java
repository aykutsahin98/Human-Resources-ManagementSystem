package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {

	 Cv findByCandidateId(int id);
	 Cv getById(int cvId);
}
