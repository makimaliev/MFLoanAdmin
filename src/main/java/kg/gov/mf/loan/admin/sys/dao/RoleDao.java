package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface RoleDao {

	public void create(Role role);
	
	public void edit(Role role);
	
	public void deleteById(long id);
	
	public Role findById (long id);
	
	public List<Role> findAll();

}
