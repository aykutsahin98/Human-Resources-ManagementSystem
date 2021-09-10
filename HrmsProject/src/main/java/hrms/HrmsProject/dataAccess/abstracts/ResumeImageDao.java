package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ResumeImage;

public interface ResumeImageDao extends JpaRepository<ResumeImage, Integer> {

	/*ResumeImage getByCandidate_id(int id);
	ResumeImage getById(int id);*/
	 List<ResumeImage> findByOrderById();
	 ResumeImage findByCvId(int id);
	 ResumeImage getById (int id);
	
}
