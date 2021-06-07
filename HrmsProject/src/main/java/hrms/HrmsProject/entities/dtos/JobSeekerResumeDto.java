package hrms.HrmsProject.entities.dtos;

import java.util.List;

import hrms.HrmsProject.entities.concretes.JobSeeker;
import hrms.HrmsProject.entities.concretes.ResumeEducation;
import hrms.HrmsProject.entities.concretes.ResumeExperience;
import hrms.HrmsProject.entities.concretes.ResumeImage;
import hrms.HrmsProject.entities.concretes.ResumeLanguage;
import hrms.HrmsProject.entities.concretes.ResumeLink;
import hrms.HrmsProject.entities.concretes.ResumeSkill;

public class JobSeekerResumeDto {

	public JobSeeker jobSeeker;
	public List<ResumeEducation> educations;
	public List<ResumeSkill> resumeSkills;
	public List<ResumeLink> resumeLinks;
	public List<ResumeExperience> jobExperiences;
	public List<ResumeLanguage> languages;
	public ResumeImage image;
}
