package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String nationalId;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeEducation> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeSkill> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeLanguage> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeCoverLetter> coverLetters;	

	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private ResumeImage image;*/
}