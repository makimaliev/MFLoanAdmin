package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class ObjectTypeServiceJpaImpl implements ObjectTypeService {
	
	@Autowired
    private ObjectTypeDao objectTypeDao;
 
    public void setObjectTypeDao(ObjectTypeDao objectTypeDao) {
        this.objectTypeDao = objectTypeDao;
    }
 
    

	@Override
	@Transactional	
	public void create(ObjectType objectType) {
		this.objectTypeDao.create(objectType);
		
	}

	@Override
	@Transactional	
	public void edit(ObjectType objectType) {
		this.objectTypeDao.edit(objectType);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.objectTypeDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public ObjectType findById(long id) {
		return this.objectTypeDao.findById(id);
	}

	

	@Override
	@Transactional	
	public ObjectType findByCode (String code) {
		return this.objectTypeDao.findByCode(code);
	}


	@Override
    @Transactional
    public List<ObjectType> findAll() {
        return this.objectTypeDao.findAll();
    }
}
