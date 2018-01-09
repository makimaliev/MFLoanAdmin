package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class RegionServiceJpaImpl implements RegionService {
	
	@Autowired
    private RegionDao regionDao;
 
    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Region region) {
		this.regionDao.create(region);
		
	}

	@Override
	@Transactional	
	public void edit(Region region) {
		this.regionDao.edit(region);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.regionDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Region findById(long id) {
		return this.regionDao.findById(id);
	}

	@Override
    @Transactional
    public List<Region> findAll() {
        return this.regionDao.findAll();
    }
}
