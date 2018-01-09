package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class InformationServiceJpaImpl implements InformationService {
	
	@Autowired
    private InformationDao informationDao;
 
    public void setInformationDao(InformationDao informationDao) {
        this.informationDao = informationDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Information information) {
		this.informationDao.create(information);
		
	}

	@Override
	@Transactional	
	public void edit(Information information) {
		this.informationDao.edit(information);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.informationDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Information findById(long id) {
		return this.informationDao.findById(id);
	}
	
	@Override
	@Transactional	
	public List<Information> findInformationBySystemObjectTypeIdAndSystemObjectId(long systemObjectTypeId,long systemObjectId)  {
		return this.informationDao.findInformationBySystemObjectTypeIdAndSystemObjectId(systemObjectTypeId, systemObjectId);
	}	

	@Override
    @Transactional
    public List<Information> findAll() {
        return this.informationDao.findAll();
    }
}
