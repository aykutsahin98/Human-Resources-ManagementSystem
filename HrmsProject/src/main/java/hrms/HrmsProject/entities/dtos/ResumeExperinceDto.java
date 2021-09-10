package hrms.HrmsProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeExperinceDto {

	
	private int cvId;

    private String workspaceName;

    private String position;

    private LocalDate startedDate;

    private LocalDate endedDate;
}
