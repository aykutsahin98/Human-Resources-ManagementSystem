package hrms.HrmsProject.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	public void mailSend(String email) {
		System.out.println("'"+email+"' mail adresine doğrulama maili gönderildi.");
	}

		
}
