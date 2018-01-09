package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface ContactService {

	
	
	public void create(Contact contact);
	
	public void edit(Contact contact);
	
	public void deleteById(long id);
	
	public Contact findById (long id);
	
	public List<Contact> findAll();
}
