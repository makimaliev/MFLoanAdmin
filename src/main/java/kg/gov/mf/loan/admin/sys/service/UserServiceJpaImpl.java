package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import kg.gov.mf.loan.admin.org.dao.StaffDao;
import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.org.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class UserServiceJpaImpl implements UserService {
	
	@Autowired
    private UserDao userDao;

	@Autowired
	private StaffDao staffDao;
 
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
 
    

	@Override
	@Transactional	
	public void create(User user) {
		this.userDao.create(user);
		
	}

	@Override
	@Transactional	
	public void edit(User user) {
		this.userDao.edit(user);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.userDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public User findById(long id) {
		return this.userDao.findById(id);
	}

	@Override
	@Transactional	
	public User findByUsername(String username) {
		return this.userDao.findByUsername(username);
	}


	@Override
	@Transactional
	public User findByStaff(Staff staff)
	{
		return null;
	}

	@Override
	@Transactional
	public User findByDepartment(Department department)
	{
		return null;
	}


	@Override
	@Transactional
	public User findByOrganization(Organization organization)
	{
		return null;
	}


	@Override
	@Transactional
	public User findByPerson(Person person)
	{
		return null;
	}



	@Override
    @Transactional
    public List<User> findAll() {
        return this.userDao.findAll();
    }
}
