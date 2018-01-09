package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface IdentityDocDao {

	public void create(IdentityDoc identityDoc);
	
	public void edit(IdentityDoc identityDoc);
	
	public void deleteById(long id);
	
	public IdentityDoc findById (long id);
	
	public List<IdentityDoc> findAll();

}
