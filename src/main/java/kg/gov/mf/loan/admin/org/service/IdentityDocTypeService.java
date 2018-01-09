package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface IdentityDocTypeService {

	
	
	public void create(IdentityDocType identityDocType);
	
	public void edit(IdentityDocType identityDocType);
	
	public void deleteById(long id);
	
	public IdentityDocType findById (long id);
	
	public List<IdentityDocType> findAll();
}
