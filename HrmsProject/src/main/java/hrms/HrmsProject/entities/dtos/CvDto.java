package hrms.HrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	
	 private int jobseekerId;
	 private String github;
	 private String linkedin;
	 private String biography;
}

