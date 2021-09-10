package hrms.HrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resume_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
//@PrimaryKeyJoinColumn(name = "user_id")
public class ResumeExperience   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;

	@Column(name = "end_date")
	private LocalDate endedDate;
	
	@Column(name= "start_date")
	private LocalDate startedDate;
	
	@Column(name= "workspace_name")
	private String workspaceName;
	
	
	@Column(name= "position")
	private String position;
	
	/*@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker candidate;*/

	public String getEndDate() {
		if (this.endedDate == null)
			return "Devam ediyor";
		return this.endedDate.toString();
	}
	
	 @ManyToOne()
	 @JoinColumn(name = "cv_id")
	 private Cv cv;
	
}