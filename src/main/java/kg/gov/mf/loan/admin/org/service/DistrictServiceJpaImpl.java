package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class DistrictServiceJpaImpl implements DistrictService {
	
	@Autowired
    private DistrictDao districtDao;
 
    public void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }
 
    

	@Override
	@Transactional	
	public void create(District district) {
		this.districtDao.create(district);
		
	}

	@Override
	@Transactional	
	public void edit(District district) {
		this.districtDao.edit(district);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.districtDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public District findById(long id) {
		return this.districtDao.findById(id);
	}

	@Override
    @Transactional
    public List<District> findAll() {
        return this.districtDao.findAll();
    }
}
