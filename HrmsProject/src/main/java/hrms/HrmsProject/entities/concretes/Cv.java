package hrms.HrmsProject.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cv")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class Cv {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker candidate;
	
	 @Column(name = "github_link")
	 private String github;

	 @Column(name = "linkedin_link")
	 private String linkedin;

	 @Column(name = "biography")
	 private String biography;


	 @OneToMany(mappedBy = "cv")
	 private List<ResumeImage> images;

	
     @OneToMany(mappedBy = "cv")
	 private List<ResumeExperience> experiences;

	 
	 @OneToMany(mappedBy = "cv")
	 private List<ResumeLanguage> languages;

	 
	 @OneToMany(mappedBy = "cv")
	 private List<ResumeEducation> educations;
	 
	 @JsonIgnoreProperties
	 @OneToMany(mappedBy = "cv")
	 private List<ResumeSkill> skills;


}
