package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class VillageServiceJpaImpl implements VillageService {
	
	@Autowired
    private VillageDao villageDao;
 
    public void setVillageDao(VillageDao villageDao) {
        this.villageDao = villageDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Village village) {
		this.villageDao.create(village);
		
	}

	@Override
	@Transactional	
	public void edit(Village village) {
		this.villageDao.edit(village);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.villageDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Village findById(long id) {
		return this.villageDao.findById(id);
	}

	@Override
    @Transactional
    public List<Village> findAll() {
        return this.villageDao.findAll();
    }
}
