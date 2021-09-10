package hrms.HrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerRegisterDto {
	
	private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalId;
    private Integer birthYear;
    
}
