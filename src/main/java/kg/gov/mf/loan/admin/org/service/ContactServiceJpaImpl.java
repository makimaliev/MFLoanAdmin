package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class ContactServiceJpaImpl implements ContactService {
	
	@Autowired
    private ContactDao contactDao;
 
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Contact contact) {
		this.contactDao.create(contact);
		
	}

	@Override
	@Transactional	
	public void edit(Contact contact) {
		this.contactDao.edit(contact);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.contactDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Contact findById(long id) {
		return this.contactDao.findById(id);
	}

	@Override
    @Transactional
    public List<Contact> findAll() {
        return this.contactDao.findAll();
    }
}
