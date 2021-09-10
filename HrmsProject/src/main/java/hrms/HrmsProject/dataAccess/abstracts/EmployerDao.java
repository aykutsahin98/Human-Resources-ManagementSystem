package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer getById(int id);

	Employer findByEmail(String email);
}
