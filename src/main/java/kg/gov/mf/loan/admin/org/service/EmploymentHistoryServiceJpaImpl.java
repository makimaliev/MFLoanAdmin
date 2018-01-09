package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class EmploymentHistoryServiceJpaImpl implements EmploymentHistoryService {
	
	@Autowired
    private EmploymentHistoryDao employmentHistoryDao;
 
    public void setEmploymentHistoryDao(EmploymentHistoryDao employmentHistoryDao) {
        this.employmentHistoryDao = employmentHistoryDao;
    }
 
    

	@Override
	@Transactional	
	public void create(EmploymentHistory employmentHistory) {
		this.employmentHistoryDao.create(employmentHistory);
		
	}

	@Override
	@Transactional	
	public void edit(EmploymentHistory employmentHistory) {
		this.employmentHistoryDao.edit(employmentHistory);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.employmentHistoryDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public EmploymentHistory findById(long id) {
		return this.employmentHistoryDao.findById(id);
	}

	@Override
    @Transactional
    public List<EmploymentHistory> findAll() {
        return this.employmentHistoryDao.findAll();
    }
}
