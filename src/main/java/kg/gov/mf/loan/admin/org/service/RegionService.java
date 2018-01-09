package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface RegionService {

	
	
	public void create(Region region);
	
	public void edit(Region region);
	
	public void deleteById(long id);
	
	public Region findById (long id);
	
	public List<Region> findAll();
}
