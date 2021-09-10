package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{

	EmployerUpdate getById(int id);

}
