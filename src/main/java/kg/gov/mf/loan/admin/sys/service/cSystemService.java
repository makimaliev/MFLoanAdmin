package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface cSystemService {

	
	
	public void create(cSystem cSystem);
	
	public void edit(cSystem cSystem);
	
	public void deleteById(long id);
	
	public cSystem findById (long id);
	
	public List<cSystem> findAll();
}
