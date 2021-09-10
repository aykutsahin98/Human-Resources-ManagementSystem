package hrms.HrmsProject.core.utilities.Cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;

/*@Service
public class CloudinaryManager implements ImageService {

private Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","du9huaxi3",
				"api_key", "785136452583429",
				"api_secret","4TZE4Ouhxn42uGjBoKsNc8WapOI"));
	}
	
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

	

}*/
