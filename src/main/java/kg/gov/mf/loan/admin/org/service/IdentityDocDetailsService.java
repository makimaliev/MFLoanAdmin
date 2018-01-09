package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface IdentityDocDetailsService {

	
	
	public void create(IdentityDocDetails identityDocDetails);
	
	public void edit(IdentityDocDetails identityDocDetails);
	
	public void deleteById(long id);
	
	public IdentityDocDetails findById (long id);
	
	public List<IdentityDocDetails> findAll();
}
