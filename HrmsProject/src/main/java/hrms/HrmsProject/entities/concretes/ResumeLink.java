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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "resume_links")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false) 
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeLink   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linkedin_link")
	private String linkedinLink;

	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker candidate;

}