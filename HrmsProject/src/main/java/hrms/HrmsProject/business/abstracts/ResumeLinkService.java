package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeLink;

public interface ResumeLinkService {

	Result add(ResumeLink resumeLink);
	Result update(ResumeLink resumeLink);
	Result delete(int id);
    DataResult<ResumeLink> getById(int id);	
	DataResult<List<ResumeLink>> getAllByJobSeekerId(int id);
	DataResult<List<ResumeLink>> getAll();
}
