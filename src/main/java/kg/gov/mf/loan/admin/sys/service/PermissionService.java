package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface PermissionService {

	
	
	public void create(Permission permission);
	
	public void edit(Permission permission);
	
	public void deleteById(long id);
	
	public Permission findById (long id);
	
	public List<Permission> findAll();
}
