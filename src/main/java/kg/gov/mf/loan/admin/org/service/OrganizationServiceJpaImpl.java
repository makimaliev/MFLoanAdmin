package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class OrganizationServiceJpaImpl implements OrganizationService {
	
	@Autowired
    private OrganizationDao organizationDao;
 
    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Organization organization) {
		this.organizationDao.create(organization);
		
	}

	@Override
	@Transactional	
	public void edit(Organization organization) {
		this.organizationDao.edit(organization);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.organizationDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Organization findById(long id) {
		return this.organizationDao.findById(id);
	}

	@Override
    @Transactional
    public List<Organization> findAll() {
        return this.organizationDao.findAll();
    }
}
