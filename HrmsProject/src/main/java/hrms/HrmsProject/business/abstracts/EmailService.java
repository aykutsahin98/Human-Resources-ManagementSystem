package hrms.HrmsProject.business.abstracts;

import hrms.HrmsProject.entities.concretes.User;

public interface EmailService {

	 void sendVerifyEmail(User user,String code);
}
