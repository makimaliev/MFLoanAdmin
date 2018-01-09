package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class FixTermServiceJpaImpl implements FixTermService {
	
	@Autowired
    private FixTermDao fixTermDao;
 
    public void setFixTermDao(FixTermDao fixTermDao) {
        this.fixTermDao = fixTermDao;
    }
 
    

	@Override
	@Transactional	
	public void create(FixTerm fixTerm) {
		this.fixTermDao.create(fixTerm);
		
	}

	@Override
	@Transactional	
	public void edit(FixTerm fixTerm) {
		this.fixTermDao.edit(fixTerm);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.fixTermDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public FixTerm findById(long id) {
		return this.fixTermDao.findById(id);
	}

	@Override
    @Transactional
    public List<FixTerm> findAll() {
        return this.fixTermDao.findAll();
    }
}
