package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class PermissionServiceJpaImpl implements PermissionService {
	
	@Autowired
    private PermissionDao permissionDao;
 
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Permission permission) {
		this.permissionDao.create(permission);
		
	}

	@Override
	@Transactional	
	public void edit(Permission permission) {
		this.permissionDao.edit(permission);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.permissionDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Permission findById(long id) {
		return this.permissionDao.findById(id);
	}

	@Override
    @Transactional
    public List<Permission> findAll() {
        return this.permissionDao.findAll();
    }
}
