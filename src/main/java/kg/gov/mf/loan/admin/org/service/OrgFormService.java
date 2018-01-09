package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface OrgFormService {

	
	
	public void create(OrgForm orgForm);
	
	public void edit(OrgForm orgForm);
	
	public void deleteById(long id);
	
	public OrgForm findById (long id);
	
	public List<OrgForm> findAll();
}
