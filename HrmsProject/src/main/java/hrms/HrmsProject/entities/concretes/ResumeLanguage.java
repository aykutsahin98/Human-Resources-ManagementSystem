package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_languages")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeLanguage     {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Min(value = 1 )
	@Max(value = 5)	
	@Column(name="language_level")
	private String level;
	
	@Column(name="language_name")
	private String languageName;
	
	/*@ManyToOne
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker candidate;*/
	
	 @ManyToOne()
	 @JoinColumn(name = "cv_id")
	 private Cv cv;

}