package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface SupervisorTermService {

	
	
	public void create(SupervisorTerm supervisorTerm);
	
	public void edit(SupervisorTerm supervisorTerm);
	
	public void deleteById(long id);
	
	public SupervisorTerm findById (long id);
	
	public List<SupervisorTerm> findAll();
}
