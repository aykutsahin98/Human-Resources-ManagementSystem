package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "resume_images")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
//@PrimaryKeyJoinColumn(name="user_id")
public class ResumeImage   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "image_url")
	private String urlAddress;
	
	
	/*@OneToOne()
    @JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
    private JobSeeker candidate;	*/
	
	@Column(name = "image_id")
	private String imageId;
	
	 @ManyToOne()
	 @JoinColumn(name = "cv_id")
	 private Cv cv;

}