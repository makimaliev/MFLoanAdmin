package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface InformationService {

	
	
	public void create(Information information);
	
	public void edit(Information information);
	
	public void deleteById(long id);
	
	public Information findById (long id);
	
	public List<Information> findAll();
	
	public List<Information> findInformationBySystemObjectTypeIdAndSystemObjectId(long systemObjectTypeId,long systemObjectId);

}
