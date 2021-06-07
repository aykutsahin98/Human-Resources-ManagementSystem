package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.*;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.*;
import hrms.HrmsProject.entities.concretes.*;
import hrms.HrmsProject.entities.dtos.JobSeekerResumeDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ResumeEducationService educationService;
	private ResumeImageService resumeImageService;
	private ResumeLinkService resumeLinkService;
	private ResumeLanguageService languageService;
	private ResumeExperienceService jobExperienceService;
	private ResumeSkillService resumeSkillService;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ResumeEducationService educationService,
			ResumeImageService resumeImageService, ResumeLinkService resumeLinkService,
			ResumeLanguageService languageService, ResumeExperienceService jobExperienceService,
			ResumeSkillService resumeSkillService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.educationService = educationService;
		this.resumeImageService = resumeImageService;
		this.resumeLinkService = resumeLinkService;
		this.languageService = languageService;
		this.jobExperienceService = jobExperienceService;
		this.resumeSkillService = resumeSkillService;
	}

	@Override
	public Result add(JobSeeker candidate) {
		this.jobSeekerDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde eklendi!");
	}

	@Override
	public Result update(JobSeeker candidate) {
		this.jobSeekerDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("İş adayı başarılı bir şekilde silindi!");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findCandidateByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerResumeDto> getCandidateCVById(int id) {
		JobSeekerResumeDto resume = new JobSeekerResumeDto();
		resume.jobExperiences = this.jobExperienceService.getAllByJobSeekerId(id).getData();
		resume.languages = this.languageService.getAllByJobSeekerId(id).getData();
		resume.image = this.resumeImageService.getByJobSeekerId(id).getData();
		resume.resumeLinks = this.resumeLinkService.getAllByJobSeekerId(id).getData();
		resume.educations = this.educationService.getAllByJobSeekerId(id).getData();
		resume.resumeSkills = this.resumeSkillService.getAllByJobSeekerId(id).getData();
		return new SuccessDataResult<JobSeekerResumeDto>(resume);
	}
	
}