package hrms.HrmsProject.business.abstracts;

import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.ActivationCode;
import hrms.HrmsProject.entities.concretes.User;

public interface ActivationCodeService {

	ActivationCode getByCode(String code);
    String createActivationCode(User user);
    Result activateUser(String code);
}
