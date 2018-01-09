package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface StaffService {

	
	
	public void create(Staff staff);
	
	public void edit(Staff staff);
	
	public void deleteById(long id);
	
	public Staff findById (long id);
	
	public List<Staff> findAll();
}
