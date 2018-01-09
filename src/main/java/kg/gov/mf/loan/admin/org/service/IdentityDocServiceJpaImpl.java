package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class IdentityDocServiceJpaImpl implements IdentityDocService {
	
	@Autowired
    private IdentityDocDao identityDocDao;
 
    public void setIdentityDocDao(IdentityDocDao identityDocDao) {
        this.identityDocDao = identityDocDao;
    }
 
    

	@Override
	@Transactional	
	public void create(IdentityDoc identityDoc) {
		this.identityDocDao.create(identityDoc);
		
	}

	@Override
	@Transactional	
	public void edit(IdentityDoc identityDoc) {
		this.identityDocDao.edit(identityDoc);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.identityDocDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public IdentityDoc findById(long id) {
		return this.identityDocDao.findById(id);
	}

	@Override
    @Transactional
    public List<IdentityDoc> findAll() {
        return this.identityDocDao.findAll();
    }
}
