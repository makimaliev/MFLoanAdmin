package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class ValidationTermServiceJpaImpl implements ValidationTermService {
	
	@Autowired
    private ValidationTermDao validationTermDao;
 
    public void setValidationTermDao(ValidationTermDao validationTermDao) {
        this.validationTermDao = validationTermDao;
    }
 
    

	@Override
	@Transactional	
	public void create(ValidationTerm validationTerm) {
		this.validationTermDao.create(validationTerm);
		
	}

	@Override
	@Transactional	
	public void edit(ValidationTerm validationTerm) {
		this.validationTermDao.edit(validationTerm);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.validationTermDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public ValidationTerm findById(long id) {
		return this.validationTermDao.findById(id);
	}

	@Override
    @Transactional
    public List<ValidationTerm> findAll() {
        return this.validationTermDao.findAll();
    }
}
