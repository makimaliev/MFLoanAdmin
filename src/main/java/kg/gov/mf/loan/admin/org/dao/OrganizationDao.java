package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface OrganizationDao {

	public void create(Organization organization);
	
	public void edit(Organization organization);
	
	public void deleteById(long id);
	
	public Organization findById (long id);
	
	public List<Organization> findAll();

}
