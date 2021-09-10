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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_educations")
@EqualsAndHashCode(callSuper = false) 
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeEducation   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;

	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_date")
	private LocalDate startedDate;
	
	@Column(name = "end_date")
	private LocalDate endedDate;
	
	/*@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker candidate;*/
	
	 @ManyToOne()
	 @JoinColumn(name = "cv_id")
	 private Cv cv;
	
	public String getEndDate() {
		if (this.endedDate == null)
			return "Devam ediyor";
		return this.endedDate.toString();
	}
	
}