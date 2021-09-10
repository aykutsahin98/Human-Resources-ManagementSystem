package hrms.HrmsProject.business.concretes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.HrmsProject.business.abstracts.ResumeImageService;
import hrms.HrmsProject.core.utilities.Cloudinary.*;
import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.CvDao;
import hrms.HrmsProject.dataAccess.abstracts.ResumeImageDao;
import hrms.HrmsProject.entities.concretes.ResumeImage;

@Service
public class ResumeImageManager implements ResumeImageService{
	
	private ResumeImageDao resumeImageDao;
	private CloudinaryService cloudinaryService;
	@SuppressWarnings("unused")
	private CvDao cvDao;
	
	@Autowired
	public ResumeImageManager(ResumeImageDao resumeImageDao,CloudinaryService cloudinaryService,CvDao cvDao) {
		super();
		this.resumeImageDao = resumeImageDao;
		//this.imageService = imageService;
		this.cloudinaryService=cloudinaryService;
        this.cvDao=cvDao;
	}

	@Override
	public DataResult<List<ResumeImage>> getAll() {
		return new SuccessDataResult<List<ResumeImage>>(this.resumeImageDao.findByOrderById(),"Data listelendi");
	}

	@Override
	public Result update(MultipartFile multipartFile, int cvId) {
		  try {
	            BufferedImage bufferedImage= ImageIO.read(multipartFile.getInputStream());
	            if(bufferedImage==null){
	                return new ErrorResult("Resim validasyonu başarısız");
	            }
	        }catch (IOException exception){
	            return new ErrorResult("Resim validasyonu başarısız");
	        }
	        ResumeImage image=this.resumeImageDao.findByCvId(cvId);
	        if(image.getImageId()==null){
	            try {
	                @SuppressWarnings("rawtypes")
					Map result=cloudinaryService.upload(multipartFile);
	                image.setName((String)result.get("original_filename"));
	                image.setUrlAddress((String)result.get("url"));
	                image.setImageId((String)result.get("public_id"));
	                this.resumeImageDao.save(image);
	                return new SuccessResult("Başarıyla eklendi");
	            }catch (IOException exception){
	                return new ErrorResult("Resim yükleme aşamasında bir sorun oldu");
	            }
	        }else if(image.getImageId()!=null){
	            //claudanry silme
	            try {
	                @SuppressWarnings({ "rawtypes", "unused" })
					Map result=cloudinaryService.delete(image.getImageId());
	                @SuppressWarnings("rawtypes")
					Map result2=cloudinaryService.upload(multipartFile);
	                image.setName((String)result2.get("original_filename"));
	                image.setUrlAddress((String)result2.get("url"));
	                image.setImageId((String)result2.get("public_id"));
	                this.resumeImageDao.save(image);
	                return new SuccessResult("Başarıyla yüklendi");
	            }catch (IOException exception){
	                return new ErrorResult("Resim yükleme aşamasında bir sorun oldu");
	            }
	        }else{
	            return new ErrorResult("Bir sorun var lütfen iletişime mail at");
	        }
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Result delete(int id) {
		 if(!this.resumeImageDao.existsById(id)){
	            return new ErrorResult("Böyle bir resim bulunamadı");
	        }
	        try {
	            ResumeImage image=this.resumeImageDao.getById(id);
	            @SuppressWarnings("unused")
				Map result=cloudinaryService.delete(image.getImageId());
	            image.setName(null);
	            image.setImageId(null);
	            image.setUrlAddress("https://res.cloudinary.com/du9huaxi3/image/upload/v1628519372/bosresim_kjihcl.png");
	            this.resumeImageDao.save(image);
	            return new SuccessResult("Resim başarıyla silindi");
	        }catch (IOException exception){
	            return new ErrorResult("Bir hata olştu");
	        }
	}

	@Override
	public DataResult<ResumeImage> getById(int id) {
		if(!this.resumeImageDao.existsById(id)){
            return new ErrorDataResult<ResumeImage>("Bu idye ait resim bulunamadı");
        }
        return new SuccessDataResult<ResumeImage>(this.resumeImageDao.getById(id),"Verilen id ye ait resim listelendi");
	}

	@Override
	public Boolean isExist(int id) {
		return this.resumeImageDao.existsById(id);
	}

	/*@Override //çalışan kodlar
	public DataResult<List<ResumeImage>> getAll() {
		 return new SuccessDataResult<List<ResumeImage>>(this.resumeImageDao.findByOrderById(),"Data listelendi");
	}

	@Override
	public Result update(MultipartFile multipartFile, int cvId) {
		  try {
	            BufferedImage bufferedImage= ImageIO.read(multipartFile.getInputStream());
	            if(bufferedImage==null){
	                return new ErrorResult("Resim validasyonu başarısız");
	            }
	        }catch (IOException exception){
	            return new ErrorResult("Resim validasyonu başarısız");
	        }
	        ResumeImage image=this.resumeImageDao.findByCvId(cvId);
	        if(image.getImageId()==null){
	            try {
	                Map result=cloudinaryService.upload(multipartFile);
	                image.setUrlAddress((String)result.get("url"));
	                image.setImageId((String)result.get("public_id"));
	                this.resumeImageDao.save(image);
	                return new SuccessResult("Başarıyla eklendi");
	            }catch (IOException exception){
	                return new ErrorResult("Resim yükleme aşamasında bir sorun oldu");
	            }
	        }else if(image.getImageId()!=null){
	            //claudanry silme
	            try {
	                Map result=cloudinaryService.delete(image.getImageId());
	                Map result2=cloudinaryService.upload(multipartFile);
	                image.setUrlAddress((String)result2.get("url"));
	                image.setImageId((String)result2.get("public_id"));
	                this.resumeImageDao.save(image);
	                return new SuccessResult("Başarıyla yüklendi");
	            }catch (IOException exception){
	                return new ErrorResult("Resim yükleme aşamasında bir sorun oldu");
	            }
	        }else{
	            return new ErrorResult("Bir sorun var lütfen iletişime mail at");
	        }
	}

	@Override
	public Result delete(int id) {
		  if(!this.resumeImageDao.existsById(id)){
	            return new ErrorResult("Böyle bir resim bulunamadı");
	        }
	        try {
	            ResumeImage image=this.resumeImageDao.findByCvId(id);
	            Map result=cloudinaryService.delete(image.getImageId());
	            image.setImageId(null);
	            image.setUrlAddress("https://res.cloudinary.com/du9huaxi3/image/upload/v1628519372/bosresim_kjihcl.png");
	            this.resumeImageDao.save(image);
	            return new SuccessResult("Resim başarıyla silindi");
	        }catch (IOException exception){
	            return new ErrorResult("Bir hata olştu");
	        }
	}

	@Override
	public DataResult<ResumeImage> getById(int id) {
		 if(!this.resumeImageDao.existsById(id)){
	            return new ErrorDataResult<ResumeImage>("Bu idye ait resim bulunamadı");
	        }
	        return new SuccessDataResult<ResumeImage>(this.resumeImageDao.findByCvId(id),"Verilen id ye ait resim listelendi");
	}

	@Override
	public Boolean isExist(int id) {
		 return this.resumeImageDao.existsById(id);
	}*///çalışan kodların bitişi ----

////////////////////////////////ESKİ KODLAR/////////////////////////////////////////////////////
	
	/*@Override
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
	}*/

}