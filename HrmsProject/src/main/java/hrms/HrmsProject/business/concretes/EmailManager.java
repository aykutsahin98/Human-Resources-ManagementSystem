package hrms.HrmsProject.business.concretes;

import hrms.HrmsProject.business.abstracts.EmailService;
import hrms.HrmsProject.entities.concretes.User;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailManager implements EmailService {
	 
	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendVerifyEmail(User user, String code) {
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setSubject("HRMS Mail Dogrulama");
	        message.setText("Hrms kayıt işleminizi tamamlamak için linke tıklayınız: http://localhost:8080/api/activationcode/active/"+code);
	        message.setTo(user.getEmail());
	        message.setFrom("hrmsresources@gmail.com");
	        emailSender.send(message);
		
	}
}
