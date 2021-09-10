package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{
	 ActivationCode findByCode(String code);
}
