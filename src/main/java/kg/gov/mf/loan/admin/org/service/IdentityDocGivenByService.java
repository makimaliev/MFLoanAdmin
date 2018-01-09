package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface IdentityDocGivenByService {

	
	
	public void create(IdentityDocGivenBy identityDocGivenBy);
	
	public void edit(IdentityDocGivenBy identityDocGivenBy);
	
	public void deleteById(long id);
	
	public IdentityDocGivenBy findById (long id);
	
	public List<IdentityDocGivenBy> findAll();
}
