package hrms.HrmsProject.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hrms.HrmsProject.core.abstracts.MailCheckService;

@Primary
@Component
public class FakeMailCheckManager implements MailCheckService {

	@Override
	public boolean mailCheck(String email) {
	
		return true;
	}

	
}
