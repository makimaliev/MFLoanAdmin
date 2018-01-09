package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface PhoneDao {

	public void create(Phone phone);
	
	public void edit(Phone phone);
	
	public void deleteById(long id);
	
	public Phone findById (long id);
	
	public List<Phone> findAll();

}
