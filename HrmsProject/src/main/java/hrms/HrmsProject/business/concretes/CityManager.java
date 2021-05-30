package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.CityService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.dataAccess.abstracts.CityDao;
import hrms.HrmsProject.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}
}
