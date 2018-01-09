package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class AokmotuServiceJpaImpl implements AokmotuService {
	
	@Autowired
    private AokmotuDao aokmotuDao;
 
    public void setAokmotuDao(AokmotuDao aokmotuDao) {
        this.aokmotuDao = aokmotuDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Aokmotu aokmotu) {
		this.aokmotuDao.create(aokmotu);
		
	}

	@Override
	@Transactional	
	public void edit(Aokmotu aokmotu) {
		this.aokmotuDao.edit(aokmotu);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.aokmotuDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Aokmotu findById(long id) {
		return this.aokmotuDao.findById(id);
	}

	@Override
    @Transactional
    public List<Aokmotu> findAll() {
        return this.aokmotuDao.findAll();
    }
}
