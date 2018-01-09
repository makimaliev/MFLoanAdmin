package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface AddressDetailsDao {

	public void create(AddressDetails addressDetails);
	
	public void edit(AddressDetails addressDetails);
	
	public void deleteById(long id);
	
	public AddressDetails findById (long id);
	
	public List<AddressDetails> findAll();

}
