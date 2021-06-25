package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer>{

	WorkingType getById(int id);
}
