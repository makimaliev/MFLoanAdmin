package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class ObjectEventServiceJpaImpl implements ObjectEventService {
	
	@Autowired
    private ObjectEventDao objectEventDao;
 
    public void setObjectEventDao(ObjectEventDao objectEventDao) {
        this.objectEventDao = objectEventDao;
    }
 
    

	@Override
	@Transactional	
	public void create(ObjectEvent objectEvent) {
		this.objectEventDao.create(objectEvent);
		
	}

	@Override
	@Transactional	
	public void edit(ObjectEvent objectEvent) {
		this.objectEventDao.edit(objectEvent);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.objectEventDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public ObjectEvent findById(long id) {
		return this.objectEventDao.findById(id);
	}

	@Override
    @Transactional
    public List<ObjectEvent> findAll() {
        return this.objectEventDao.findAll();
    }
}
