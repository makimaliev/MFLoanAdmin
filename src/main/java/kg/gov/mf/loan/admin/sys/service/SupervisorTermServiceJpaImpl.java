package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class SupervisorTermServiceJpaImpl implements SupervisorTermService {
	
	@Autowired
    private SupervisorTermDao supervisorTermDao;
 
    public void setSupervisorTermDao(SupervisorTermDao supervisorTermDao) {
        this.supervisorTermDao = supervisorTermDao;
    }
 
    

	@Override
	@Transactional	
	public void create(SupervisorTerm supervisorTerm) {
		this.supervisorTermDao.create(supervisorTerm);
		
	}

	@Override
	@Transactional	
	public void edit(SupervisorTerm supervisorTerm) {
		this.supervisorTermDao.edit(supervisorTerm);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.supervisorTermDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public SupervisorTerm findById(long id) {
		return this.supervisorTermDao.findById(id);
	}

	@Override
    @Transactional
    public List<SupervisorTerm> findAll() {
        return this.supervisorTermDao.findAll();
    }
}
