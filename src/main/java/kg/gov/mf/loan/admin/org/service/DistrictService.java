package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import kg.gov.mf.loan.admin.org.model.*;

public interface DistrictService {

	
	public void create(District district);
	
	public void edit(District district);
	
	public void deleteById(long id);
	
	public District findById (long id);
	
	public List<District> findAll();	
	
}
