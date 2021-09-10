package hrms.HrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLanguageDto {

	private int cvId;
    private String languageName;
    private String level;
}
