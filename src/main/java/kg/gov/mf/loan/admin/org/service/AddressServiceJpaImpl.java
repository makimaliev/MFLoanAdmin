package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class AddressServiceJpaImpl implements AddressService {
	
	@Autowired
    private AddressDao addressDao;
 
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Address address) {
		this.addressDao.create(address);
		
	}

	@Override
	@Transactional	
	public void edit(Address address) {
		this.addressDao.edit(address);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.addressDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Address findById(long id) {
		return this.addressDao.findById(id);
	}

	@Override
    @Transactional
    public List<Address> findAll() {
        return this.addressDao.findAll();
    }
}
