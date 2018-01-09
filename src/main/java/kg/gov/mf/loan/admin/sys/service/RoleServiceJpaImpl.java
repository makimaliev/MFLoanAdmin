package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class RoleServiceJpaImpl implements RoleService {
	
	@Autowired
    private RoleDao roleDao;
 
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Role role) {
		this.roleDao.create(role);
		
	}

	@Override
	@Transactional	
	public void edit(Role role) {
		this.roleDao.edit(role);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.roleDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Role findById(long id) {
		return this.roleDao.findById(id);
	}

	@Override
    @Transactional
    public List<Role> findAll() {
        return this.roleDao.findAll();
    }
}
