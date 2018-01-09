package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface IdentityDocService {

	
	
	public void create(IdentityDoc identityDoc);
	
	public void edit(IdentityDoc identityDoc);
	
	public void deleteById(long id);
	
	public IdentityDoc findById (long id);
	
	public List<IdentityDoc> findAll();
}
