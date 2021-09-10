package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Cv;

public interface CvService {

	
		public Result add(int candidateId);
	    public DataResult<List<Cv>> getAll();

	    public DataResult<Cv> getByCvId(int cvId);
	    public DataResult<Cv> getByCandidateId(int candidateId);

	    public Result updateGithub(String githublink, int cvId);
	    public Result deleteGithub(int cvId);

	    public Result updateLinkedin(String linkedinlink, int cvId);
	    public Result deleteLinkedin(int cvId);

	    public Result updateBiography(String biography, int cvId);
	    public Result deleteBiography(int cvId);
}
