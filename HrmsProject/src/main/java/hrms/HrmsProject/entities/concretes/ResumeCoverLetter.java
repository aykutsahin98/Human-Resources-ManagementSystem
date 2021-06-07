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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "resume_cover_letter")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeCoverLetter  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	@JsonIgnore
	private JobSeeker candidate;
	
	public ResumeCoverLetter(String content, int jobSeekerId) {
		super();
		this.content = content;
		this.candidate.setId(jobSeekerId);
	}	
}