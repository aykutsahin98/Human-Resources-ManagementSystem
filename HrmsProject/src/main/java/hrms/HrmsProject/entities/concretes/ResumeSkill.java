package hrms.HrmsProject.entities.concretes;


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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_skills")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeSkill   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "skills_name")
	private String skillsName;
	
	/*@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker candidate;*/
	
	 @ManyToOne()
	 @JoinColumn(name = "cv_id")
	 private Cv cv;

}