package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
