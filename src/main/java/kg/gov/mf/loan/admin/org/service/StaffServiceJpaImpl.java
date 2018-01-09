package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class StaffServiceJpaImpl implements StaffService {
	
	@Autowired
    private StaffDao staffDao;
 
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Staff staff) {
		this.staffDao.create(staff);
		
	}

	@Override
	@Transactional	
	public void edit(Staff staff) {
		this.staffDao.edit(staff);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.staffDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Staff findById(long id) {
		return this.staffDao.findById(id);
	}

	@Override
    @Transactional
    public List<Staff> findAll() {
        return this.staffDao.findAll();
    }
}
