package hrms.HrmsProject.business.abstracts;

import java.util.List;

import hrms.HrmsProject.core.utilities.results.DataResult;
import hrms.HrmsProject.core.utilities.results.Result;
import hrms.HrmsProject.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	public DataResult<List<FavoriteJobAdvert>> getByCandidateId(int candidateId);
	public Result addFavorite(int candidateId,int jobAdvertId);
	public Result removeFavorite(int favoriteId);
}
