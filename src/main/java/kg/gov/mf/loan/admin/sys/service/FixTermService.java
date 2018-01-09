package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface FixTermService {

	
	
	public void create(FixTerm fixTerm);
	
	public void edit(FixTerm fixTerm);
	
	public void deleteById(long id);
	
	public FixTerm findById (long id);
	
	public List<FixTerm> findAll();
}
