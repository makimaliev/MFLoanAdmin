package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface AddressDetailsService {

	
	
	public void create(AddressDetails addressDetails);
	
	public void edit(AddressDetails addressDetails);
	
	public void deleteById(long id);
	
	public AddressDetails findById (long id);
	
	public List<AddressDetails> findAll();
}
