package kg.gov.mf.loan.admin.org.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class RegionServiceJpaImpl implements RegionService {
	
	@Autowired
    private RegionDao regionDao;

	@Autowired
	private DistrictDao districtDao;

 
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
	public Region findByIdFull(long id)
	{
		Region region = this.regionDao.findById(id);

		region.setDistrict(new HashSet<>(this.districtDao.findByRegion(region)));

		return region;
	}


	@Override
    @Transactional
    public List<Region> findAll() {
        return this.regionDao.findAll();
    }

	@Override
	@Transactional
	public Region findByCode(String code) {
		return this.regionDao.findByCode(code);
	}
}
