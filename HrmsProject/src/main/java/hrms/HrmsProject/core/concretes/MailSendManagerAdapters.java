package hrms.HrmsProject.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import hrms.HrmsProject.core.abstracts.MailSendService;

public class MailSendManagerAdapters extends MailSendService{

private MailSendManagerAdapters mailSendManager;
	
	@Autowired
	public MailSendManagerAdapters(MailSendManagerAdapters mailSendManager) {
		this.mailSendManager = mailSendManager;
	}
	
	@Override
	public void mailSend(String email) {
		mailSendManager.mailSend(email);
	}
}
