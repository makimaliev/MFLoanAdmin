package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import kg.gov.mf.loan.admin.org.model.*;

public interface VillageService {

	
	public void create(Village village);
	
	public void edit(Village village);
	
	public void deleteById(long id);
	
	public Village findById (long id);
	
	public List<Village> findAll();	
	
}
