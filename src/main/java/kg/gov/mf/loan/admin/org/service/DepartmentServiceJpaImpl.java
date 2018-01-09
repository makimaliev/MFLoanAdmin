package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class DepartmentServiceJpaImpl implements DepartmentService {
	
	@Autowired
    private DepartmentDao departmentDao;
 
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Department department) {
		this.departmentDao.create(department);
		
	}

	@Override
	@Transactional	
	public void edit(Department department) {
		this.departmentDao.edit(department);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.departmentDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Department findById(long id) {
		return this.departmentDao.findById(id);
	}

	@Override
    @Transactional
    public List<Department> findAll() {
        return this.departmentDao.findAll();
    }
}
