package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ActivationByPersonnel;

public interface ActivationByPersonnelDao extends JpaRepository<ActivationByPersonnel,Integer> {

	 ActivationByPersonnel findByEmployeId(int id);
}
