package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface PermissionDao {

	public void create(Permission permission);
	
	public void edit(Permission permission);
	
	public void deleteById(long id);
	
	public Permission findById (long id);
	
	public List<Permission> findAll();

}
