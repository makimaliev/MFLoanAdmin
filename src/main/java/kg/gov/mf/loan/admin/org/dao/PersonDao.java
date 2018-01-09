package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface PersonDao {

	public void create(Person person);
	
	public void edit(Person person);
	
	public void deleteById(long id);
	
	public Person findById (long id);
	
	public List<Person> findAll();

}
