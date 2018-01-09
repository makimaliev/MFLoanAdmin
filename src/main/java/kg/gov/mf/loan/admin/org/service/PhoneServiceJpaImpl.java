package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class PhoneServiceJpaImpl implements PhoneService {
	
	@Autowired
    private PhoneDao phoneDao;
 
    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Phone phone) {
		this.phoneDao.create(phone);
		
	}

	@Override
	@Transactional	
	public void edit(Phone phone) {
		this.phoneDao.edit(phone);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.phoneDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Phone findById(long id) {
		return this.phoneDao.findById(id);
	}

	@Override
    @Transactional
    public List<Phone> findAll() {
        return this.phoneDao.findAll();
    }
}
