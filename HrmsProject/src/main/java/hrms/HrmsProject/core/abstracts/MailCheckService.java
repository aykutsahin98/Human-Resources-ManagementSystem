package hrms.HrmsProject.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface MailCheckService {

	public boolean mailCheck(String email);
}
