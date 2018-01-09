package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class OrgFormServiceJpaImpl implements OrgFormService {
	
	@Autowired
    private OrgFormDao orgFormDao;
 
    public void setOrgFormDao(OrgFormDao orgFormDao) {
        this.orgFormDao = orgFormDao;
    }
 
    

	@Override
	@Transactional	
	public void create(OrgForm orgForm) {
		this.orgFormDao.create(orgForm);
		
	}

	@Override
	@Transactional	
	public void edit(OrgForm orgForm) {
		this.orgFormDao.edit(orgForm);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.orgFormDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public OrgForm findById(long id) {
		return this.orgFormDao.findById(id);
	}

	@Override
    @Transactional
    public List<OrgForm> findAll() {
        return this.orgFormDao.findAll();
    }
}
