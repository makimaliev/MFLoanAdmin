package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class IdentityDocTypeServiceJpaImpl implements IdentityDocTypeService {
	
	@Autowired
    private IdentityDocTypeDao identityDocTypeDao;
 
    public void setIdentityDocTypeDao(IdentityDocTypeDao identityDocTypeDao) {
        this.identityDocTypeDao = identityDocTypeDao;
    }
 
    

	@Override
	@Transactional	
	public void create(IdentityDocType identityDocType) {
		this.identityDocTypeDao.create(identityDocType);
		
	}

	@Override
	@Transactional	
	public void edit(IdentityDocType identityDocType) {
		this.identityDocTypeDao.edit(identityDocType);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.identityDocTypeDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public IdentityDocType findById(long id) {
		return this.identityDocTypeDao.findById(id);
	}

	@Override
    @Transactional
    public List<IdentityDocType> findAll() {
        return this.identityDocTypeDao.findAll();
    }
}
