package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class PersonServiceJpaImpl implements PersonService {
	
	@Autowired
    private PersonDao personDao;
 
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Person person) {
		this.personDao.create(person);
		
	}

	@Override
	@Transactional	
	public void edit(Person person) {
		this.personDao.edit(person);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.personDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Person findById(long id) {
		return this.personDao.findById(id);
	}

	@Override
    @Transactional
    public List<Person> findAll() {
        return this.personDao.findAll();
    }
}
