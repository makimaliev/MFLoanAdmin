package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface IdentityDocGivenByDao {

	public void create(IdentityDocGivenBy identityDocGivenBy);
	
	public void edit(IdentityDocGivenBy identityDocGivenBy);
	
	public void deleteById(long id);
	
	public IdentityDocGivenBy findById (long id);
	
	public List<IdentityDocGivenBy> findAll();

}
