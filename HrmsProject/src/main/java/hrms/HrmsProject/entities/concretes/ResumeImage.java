package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "resume_images")
@NoArgsConstructor
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeImage   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "image_url")
	private String urlAddress;
	
	@OneToOne()
    @JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
    private JobSeeker candidate;	

}