package hrms.HrmsProject.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ResumeImage;

public interface ResumeImageService {

	/*Result add(ResumeImage resumeImage, MultipartFile imageFile);
	Result update(ResumeImage resumeImage);
	Result delete(int id);
	DataResult<ResumeImage> getById(int id);	
	DataResult<List<ResumeImage>> getAll();
	DataResult<ResumeImage> getByJobSeekerId(int id);*/
	
	 	DataResult<List<ResumeImage>> getAll();
	    Result update(MultipartFile multipartFile,int cvId);
	    Result delete(int id);
	    DataResult<ResumeImage> getById(int id);
	    Boolean isExist(int id);
	  
}
