package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface AddressService {

	
	
	public void create(Address address);
	
	public void edit(Address address);
	
	public void deleteById(long id);
	
	public Address findById (long id);
	
	public List<Address> findAll();
}
