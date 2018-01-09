package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface PersonService {

	
	
	public void create(Person person);
	
	public void edit(Person person);
	
	public void deleteById(long id);
	
	public Person findById (long id);
	
	public List<Person> findAll();
}
