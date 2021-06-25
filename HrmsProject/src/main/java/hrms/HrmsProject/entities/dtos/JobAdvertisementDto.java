package hrms.HrmsProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	
	private int numberOfOpenPositions;

	private String applicationDeadline;

	private int workingTypeId;

	private int jobPositionId;

	private int employerId;

	private String jobDescription;

	private int cityId;

	private int minSalary;

	private int maxSalary;
	
	private String creationDate;

}