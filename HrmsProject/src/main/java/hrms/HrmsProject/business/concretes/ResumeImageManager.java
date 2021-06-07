package hrms.HrmsProject.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.HrmsProject.business.abstracts.ResumeImageService;
import hrms.HrmsProject.core.utilities.Cloudinary.*;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.ResumeImageDao;
import hrms.HrmsProject.entities.concretes.ResumeImage;

@Service
public class ResumeImageManager implements ResumeImageService{
	
	private ResumeImageDao resumeImageDao;
	private ImageService imageService;
	
	@Autowired
	public ResumeImageManager(ResumeImageDao resumeImageDao,ImageService imageService) {
		super();
		this.resumeImageDao = resumeImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(ResumeImage resumeImage, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.imageService.uploadImageFile(imageFile).getData();
		resumeImage.setUrlAddress(uploadImage.get("url"));
		this.resumeImageDao.save(resumeImage);
		return new SuccessResult("Fotoğrafınız Sisteme Başarıyla Eklendi");
	}

	@Override
	public Result update(ResumeImage resumeImage) {
		this.resumeImageDao.save(resumeImage);
		return new SuccessResult("Fotoğrafınız Güncellenmiştir!");
	}

	@Override
	public Result delete(int id) {
		this.resumeImageDao.deleteById(id);
		return new SuccessResult("Fotoğrafınız Silinmiştir!");
	}

	@Override
	public DataResult<ResumeImage> getById(int id) {
		return new SuccessDataResult<ResumeImage>(this.resumeImageDao.getById(id));
	}

	@Override
	public DataResult<List<ResumeImage>> getAll() {
		return new SuccessDataResult<List<ResumeImage>>(this.resumeImageDao.findAll());	
	}

	@Override
	public DataResult<ResumeImage> getByJobSeekerId(int id) {
		return new SuccessDataResult<ResumeImage>(this.resumeImageDao.getByCandidate_id(id));
	}

}