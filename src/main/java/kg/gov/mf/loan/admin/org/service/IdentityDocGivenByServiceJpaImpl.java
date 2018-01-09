package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class IdentityDocGivenByServiceJpaImpl implements IdentityDocGivenByService {
	
	@Autowired
    private IdentityDocGivenByDao identityDocGivenByDao;
 
    public void setIdentityDocGivenByDao(IdentityDocGivenByDao identityDocGivenByDao) {
        this.identityDocGivenByDao = identityDocGivenByDao;
    }
 
    

	@Override
	@Transactional	
	public void create(IdentityDocGivenBy identityDocGivenBy) {
		this.identityDocGivenByDao.create(identityDocGivenBy);
		
	}

	@Override
	@Transactional	
	public void edit(IdentityDocGivenBy identityDocGivenBy) {
		this.identityDocGivenByDao.edit(identityDocGivenBy);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.identityDocGivenByDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public IdentityDocGivenBy findById(long id) {
		return this.identityDocGivenByDao.findById(id);
	}

	@Override
    @Transactional
    public List<IdentityDocGivenBy> findAll() {
        return this.identityDocGivenByDao.findAll();
    }
}
