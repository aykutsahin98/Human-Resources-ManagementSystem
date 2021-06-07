package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService {

	Result add(ResumeLanguage language);
	Result update(ResumeLanguage language);
	Result delete(int id);
	DataResult<ResumeLanguage> getById(int id);
	DataResult<List<ResumeLanguage>>  getAll();
	DataResult<List<ResumeLanguage>>  getAllByJobSeekerId(int id);
}
