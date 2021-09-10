package hrms.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HrmsProject.business.abstracts.FavoriteJobAdvertService;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.ErrorResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.core.utilities.results.SuccessDataResult;
import hrms.HrmsProject.core.utilities.results.SuccessResult;
import hrms.HrmsProject.dataAccess.abstracts.FavoriteDao;
import hrms.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import hrms.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import hrms.HrmsProject.entities.concretes.FavoriteJobAdvert;


@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService{

	private FavoriteDao favoriteJobAdvertDao;
	private JobSeekerDao candidateDao;
	private JobAdvertisementDao jobAdvertDao;
	
	@Autowired
	public FavoriteJobAdvertManager(FavoriteDao favoriteJobAdvertDao,JobSeekerDao candidateDao,JobAdvertisementDao jobAdvertDao) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
		this.candidateDao=candidateDao;
		this.jobAdvertDao=jobAdvertDao;
	}
	@Override
	public DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<FavoriteJobAdvert>>(this.favoriteJobAdvertDao.getByCandidateId(candidateId));
	}
	@Override
	public Result addFavorite(int candidateId, int jobAdvertId) {
		if(this.favoriteJobAdvertDao.existsByCandidate_IdAndJobAdvert_Id(candidateId, jobAdvertId)) {
			return new ErrorResult("Bu ilan favorilerinizde mevcut");
		}
		FavoriteJobAdvert favoriteJobAdvert = new FavoriteJobAdvert();
		favoriteJobAdvert.setCandidate(this.candidateDao.getById(candidateId));
		favoriteJobAdvert.setJobAdvert(this.jobAdvertDao.getById(jobAdvertId));
		this.favoriteJobAdvertDao.save(favoriteJobAdvert);
		return new SuccessResult("İlan favorilere eklendi");
	}
	@Override
	public Result removeFavorite(int favoriteId) {
		this.favoriteJobAdvertDao.deleteById(favoriteId);
		return new SuccessResult("İlan favorilerden kaldırıldı");
	}
}