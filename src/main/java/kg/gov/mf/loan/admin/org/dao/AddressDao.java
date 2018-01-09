package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface AddressDao {

	public void create(Address address);
	
	public void edit(Address address);
	
	public void deleteById(long id);
	
	public Address findById (long id);
	
	public List<Address> findAll();

}
