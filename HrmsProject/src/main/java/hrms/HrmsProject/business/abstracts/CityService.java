package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}