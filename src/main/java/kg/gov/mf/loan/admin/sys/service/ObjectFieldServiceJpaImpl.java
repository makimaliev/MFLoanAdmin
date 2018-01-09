package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class ObjectFieldServiceJpaImpl implements ObjectFieldService {
	
	@Autowired
    private ObjectFieldDao objectFieldDao;
 
    public void setObjectFieldDao(ObjectFieldDao objectFieldDao) {
        this.objectFieldDao = objectFieldDao;
    }
 
    

	@Override
	@Transactional	
	public void create(ObjectField objectField) {
		this.objectFieldDao.create(objectField);
		
	}

	@Override
	@Transactional	
	public void edit(ObjectField objectField) {
		this.objectFieldDao.edit(objectField);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.objectFieldDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public ObjectField findById(long id) {
		return this.objectFieldDao.findById(id);
	}
	
	@Override
	@Transactional	
	public ObjectField findByCode (String code) {
		return this.objectFieldDao.findByCode(code);
	}

	@Override
    @Transactional
    public List<ObjectField> findAll() {
        return this.objectFieldDao.findAll();
    }
}
