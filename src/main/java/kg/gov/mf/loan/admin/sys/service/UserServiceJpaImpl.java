package kg.gov.mf.loan.admin.sys.service;

import java.util.List;
import java.util.Set;

import kg.gov.mf.loan.admin.org.dao.DepartmentDao;
import kg.gov.mf.loan.admin.org.dao.OrganizationDao;
import kg.gov.mf.loan.admin.org.dao.StaffDao;
import kg.gov.mf.loan.admin.org.model.*;
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

	@Autowired
	private OrganizationDao organizationDao;

	@Autowired
	private DepartmentDao departmentDao;


 
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
		return userDao.findByStaff(staff);
	}

	@Override
	@Transactional
	public User findByDepartment(Department department)
	{
		Organization gaubk = organizationDao.findById((long)1);
		System.out.println(gaubk.getName());
		System.out.println(department.getName());

		return userDao.findByStaff(staffDao.findByOrganizationAndDepartment(organizationDao.findById((long)1),department));
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
