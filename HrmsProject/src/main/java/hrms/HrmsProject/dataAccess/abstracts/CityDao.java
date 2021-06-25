package hrms.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.HrmsProject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City getById(int id);
}
