package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class EmploymentHistoryEventTypeServiceJpaImpl implements EmploymentHistoryEventTypeService {
	
	@Autowired
    private EmploymentHistoryEventTypeDao employmentHistoryEventTypeDao;
 
    public void setEmploymentHistoryEventTypeDao(EmploymentHistoryEventTypeDao employmentHistoryEventTypeDao) {
        this.employmentHistoryEventTypeDao = employmentHistoryEventTypeDao;
    }
 
    

	@Override
	@Transactional	
	public void create(EmploymentHistoryEventType employmentHistoryEventType) {
		this.employmentHistoryEventTypeDao.create(employmentHistoryEventType);
		
	}

	@Override
	@Transactional	
	public void edit(EmploymentHistoryEventType employmentHistoryEventType) {
		this.employmentHistoryEventTypeDao.edit(employmentHistoryEventType);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.employmentHistoryEventTypeDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public EmploymentHistoryEventType findById(long id) {
		return this.employmentHistoryEventTypeDao.findById(id);
	}

	@Override
    @Transactional
    public List<EmploymentHistoryEventType> findAll() {
        return this.employmentHistoryEventTypeDao.findAll();
    }
}
