package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface OrgFormDao {

	public void create(OrgForm orgForm);
	
	public void edit(OrgForm orgForm);
	
	public void deleteById(long id);
	
	public OrgForm findById (long id);
	
	public List<OrgForm> findAll();

}
