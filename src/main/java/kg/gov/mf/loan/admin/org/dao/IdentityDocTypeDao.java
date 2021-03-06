package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface IdentityDocTypeDao {

	public void create(IdentityDocType identityDocType);
	
	public void edit(IdentityDocType identityDocType);
	
	public void deleteById(long id);
	
	public IdentityDocType findById (long id);
	
	public List<IdentityDocType> findAll();

}
