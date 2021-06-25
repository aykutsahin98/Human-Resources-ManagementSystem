package hrms.HrmsProject.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.JobAdvertisementService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CityDao;
import hrms.HrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import hrms.HrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.HrmsProject.dataAccess.abstracts.WorkingTypeDao;
import hrms.HrmsProject.entities.concretes.JobAdvertisement;
import hrms.HrmsProject.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
private JobAdvertisementDao jobAdvertisementDao;
private CityDao cityDao;
private EmployerDao employerDao;
private JobPositionDao jobPositionDao;
private WorkingTypeDao workTypeDao;

	
@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao, EmployerDao employerDao,
		JobPositionDao jobPositionDao, WorkingTypeDao workTypeDao) {
	super();
	this.jobAdvertisementDao = jobAdvertisementDao;
	this.cityDao = cityDao;
	this.employerDao = employerDao;
	this.jobPositionDao = jobPositionDao;
	this.workTypeDao = workTypeDao;
}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"İş İlanları Listelendi.");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirm(boolean isConfirm) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsConfirm(isConfirm));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsConfirmAndIsActive(isConfirm, isActive));
	}

	@Override
	public Result updateIsConfirm(boolean isConfirm, int id) {
		this.jobAdvertisementDao.updateIsConfirm(isConfirm, id);
		return new SuccessResult("İş ilanı onaylandı");
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setId(0);
		jobAdvertisement.setJobDescription(jobAdvertisementDto.getJobDescription());
		jobAdvertisement.setMinSalary(jobAdvertisementDto.getMinSalary());
		jobAdvertisement.setMaxSalary(jobAdvertisementDto.getMaxSalary());
		jobAdvertisement.setNumberOfOpenPositions(jobAdvertisementDto.getNumberOfOpenPositions());
		jobAdvertisement.setCreationDate(jobAdvertisementDto.getCreationDate());

		jobAdvertisement.setApplicationDeadline(jobAdvertisementDto.getApplicationDeadline());	
		jobAdvertisement.setActive(true);
		jobAdvertisement.setConfirm(false);
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setJobPosition(this.jobPositionDao.getById(jobAdvertisementDto.getJobPositionId()));
		jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setWorkingType(this.workTypeDao.getById(jobAdvertisementDto.getWorkingTypeId()));
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilani başarı şekilde eklendi");
	}

	@Override
	public Result updateIsActive(boolean isActive, int userId, int id) {
		this.jobAdvertisementDao.updateIsActive(isActive,  id);
		return new SuccessResult("İş ilanı aktiflik durumu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> sortByReleaseDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),
				"Yayın tarihine göre artan olarak listelendi");
	}
}
