package hrms.HrmsProject.core.concretes;

import java.rmi.RemoteException;

import hrms.HrmsProject.core.abstracts.MernisCheckService;
import hrms.HrmsProject.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisCheckAdapters implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(jobSeeker.getNationalId()), 
						jobSeeker.getFirstName(), 
						jobSeeker.getLastName(), 
						jobSeeker.getBirthYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
