package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class EmploymentHistoryEventServiceJpaImpl implements EmploymentHistoryEventService {
	
	@Autowired
    private EmploymentHistoryEventDao employmentHistoryEventDao;
 
    public void setEmploymentHistoryEventDao(EmploymentHistoryEventDao employmentHistoryEventDao) {
        this.employmentHistoryEventDao = employmentHistoryEventDao;
    }
 
    

	@Override
	@Transactional	
	public void create(EmploymentHistoryEvent employmentHistoryEvent) {
		this.employmentHistoryEventDao.create(employmentHistoryEvent);
		
	}

	@Override
	@Transactional	
	public void edit(EmploymentHistoryEvent employmentHistoryEvent) {
		this.employmentHistoryEventDao.edit(employmentHistoryEvent);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.employmentHistoryEventDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public EmploymentHistoryEvent findById(long id) {
		return this.employmentHistoryEventDao.findById(id);
	}

	@Override
    @Transactional
    public List<EmploymentHistoryEvent> findAll() {
        return this.employmentHistoryEventDao.findAll();
    }
}
