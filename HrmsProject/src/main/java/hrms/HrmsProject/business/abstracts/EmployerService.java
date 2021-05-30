package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.Employer;

public interface EmployerService {

	public Result login(String email, String password);
	public Result register(Employer employer);
	public Result delete(Employer employer);

	public List<Employer> getAll();
	public List<String> getAllEmails();

}
