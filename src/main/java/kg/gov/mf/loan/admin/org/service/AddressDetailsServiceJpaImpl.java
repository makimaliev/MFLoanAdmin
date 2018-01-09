package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class AddressDetailsServiceJpaImpl implements AddressDetailsService {
	
	@Autowired
    private AddressDetailsDao addressDetailsDao;
 
    public void setAddressDetailsDao(AddressDetailsDao addressDetailsDao) {
        this.addressDetailsDao = addressDetailsDao;
    }
 
    

	@Override
	@Transactional	
	public void create(AddressDetails addressDetails) {
		this.addressDetailsDao.create(addressDetails);
		
	}

	@Override
	@Transactional	
	public void edit(AddressDetails addressDetails) {
		this.addressDetailsDao.edit(addressDetails);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.addressDetailsDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public AddressDetails findById(long id) {
		return this.addressDetailsDao.findById(id);
	}

	@Override
    @Transactional
    public List<AddressDetails> findAll() {
        return this.addressDetailsDao.findAll();
    }
}
