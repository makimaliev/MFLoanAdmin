package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class IdentityDocDetailsServiceJpaImpl implements IdentityDocDetailsService {
	
	@Autowired
    private IdentityDocDetailsDao identityDocDetailsDao;
 
    public void setIdentityDocDetailsDao(IdentityDocDetailsDao identityDocDetailsDao) {
        this.identityDocDetailsDao = identityDocDetailsDao;
    }
 
    

	@Override
	@Transactional	
	public void create(IdentityDocDetails identityDocDetails) {
		this.identityDocDetailsDao.create(identityDocDetails);
		
	}

	@Override
	@Transactional	
	public void edit(IdentityDocDetails identityDocDetails) {
		this.identityDocDetailsDao.edit(identityDocDetails);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.identityDocDetailsDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public IdentityDocDetails findById(long id) {
		return this.identityDocDetailsDao.findById(id);
	}

	@Override
    @Transactional
    public List<IdentityDocDetails> findAll() {
        return this.identityDocDetailsDao.findAll();
    }
}
