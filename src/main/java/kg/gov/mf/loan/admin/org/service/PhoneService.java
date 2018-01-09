package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface PhoneService {

	
	
	public void create(Phone phone);
	
	public void edit(Phone phone);
	
	public void deleteById(long id);
	
	public Phone findById (long id);
	
	public List<Phone> findAll();
}
