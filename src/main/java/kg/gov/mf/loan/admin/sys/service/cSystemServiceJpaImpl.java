package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class cSystemServiceJpaImpl implements cSystemService {
	
	@Autowired
    private cSystemDao cSystemDao;
 
    public void setcSystemDao(cSystemDao cSystemDao) {
        this.cSystemDao = cSystemDao;
    }
 
    

	@Override
	@Transactional	
	public void create(cSystem cSystem) {
		this.cSystemDao.create(cSystem);
		
	}

	@Override
	@Transactional	
	public void edit(cSystem cSystem) {
		this.cSystemDao.edit(cSystem);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.cSystemDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public cSystem findById(long id) {
		return this.cSystemDao.findById(id);
	}

	@Override
    @Transactional
    public List<cSystem> findAll() {
        return this.cSystemDao.findAll();
    }
}
