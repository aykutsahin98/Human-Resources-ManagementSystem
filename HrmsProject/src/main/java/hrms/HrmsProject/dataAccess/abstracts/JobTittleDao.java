package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.JobTittle;

public interface JobTittleDao  extends JpaRepository<JobTittle, Integer> {

}
