package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterService {

	Result add(ResumeCoverLetter coverLetter);
	Result update(ResumeCoverLetter coverLetter);
	Result delete(int id);
	DataResult<ResumeCoverLetter> getById(int id);	
	DataResult<List<ResumeCoverLetter>> getAll();
}
