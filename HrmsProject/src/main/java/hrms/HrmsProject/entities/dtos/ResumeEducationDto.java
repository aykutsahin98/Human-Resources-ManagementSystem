package hrms.HrmsProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEducationDto {

	 private int CvId;
	    private String schoolName;
	    private String department;
	    private LocalDate startedDate;
	    private LocalDate endedDate;
}
