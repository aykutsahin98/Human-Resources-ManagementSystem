package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.WorkingTypeService;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.WorkingTypeDao;
import hrms.HrmsProject.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{

	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
		
	}
	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new  SuccessResult("İş Tipi Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll(),"Başarıyla Listelendi");
	}

}
