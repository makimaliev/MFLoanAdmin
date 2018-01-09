package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface IdentityDocDetailsDao {

	public void create(IdentityDocDetails identityDocDetails);
	
	public void edit(IdentityDocDetails identityDocDetails);
	
	public void deleteById(long id);
	
	public IdentityDocDetails findById (long id);
	
	public List<IdentityDocDetails> findAll();

}
