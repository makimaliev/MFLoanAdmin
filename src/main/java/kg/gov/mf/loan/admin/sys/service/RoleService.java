package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface RoleService {

	
	
	public void create(Role role);
	
	public void edit(Role role);
	
	public void deleteById(long id);
	
	public Role findById (long id);
	
	public List<Role> findAll();
}
