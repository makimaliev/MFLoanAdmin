package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface OrganizationService {

	
	
	public void create(Organization organization);
	
	public void edit(Organization organization);
	
	public void deleteById(long id);
	
	public Organization findById (long id);
	
	public List<Organization> findAll();
}
