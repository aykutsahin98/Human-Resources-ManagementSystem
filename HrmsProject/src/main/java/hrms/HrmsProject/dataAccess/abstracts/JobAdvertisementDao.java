package hrms.HrmsProject.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.entities.concretes.JobAdvertisement;

@Service
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getByIsActive();

	List<JobAdvertisement> getByIsConfirm(boolean isConfirm);

	List<JobAdvertisement> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	JobAdvertisement getById(int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isConfirm=:isConfirm where u.id=:id ")
	void updateIsConfirm(boolean isConfirm, int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isActive=:isActive where u.employer.id=:id and u.id=:id ")
	void updateIsActive(boolean isActive,  int id);
}
