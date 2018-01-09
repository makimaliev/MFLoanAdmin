package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class PositionServiceJpaImpl implements PositionService {
	
	@Autowired
    private PositionDao positionDao;
 
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Position position) {
		this.positionDao.create(position);
		
	}

	@Override
	@Transactional	
	public void edit(Position position) {
		this.positionDao.edit(position);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.positionDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Position findById(long id) {
		return this.positionDao.findById(id);
	}

	@Override
    @Transactional
    public List<Position> findAll() {
        return this.positionDao.findAll();
    }
}
