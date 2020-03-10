package kg.gov.mf.loan.admin.sys.service;

import kg.gov.mf.loan.admin.org.dao.DepartmentDao;
import kg.gov.mf.loan.admin.org.dao.OrganizationDao;
import kg.gov.mf.loan.admin.org.dao.StaffDao;
import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.org.service.GenericServiceAdminImpl;
import kg.gov.mf.loan.admin.sys.dao.UserDao;
import kg.gov.mf.loan.admin.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceJpaImpl extends GenericServiceAdminImpl<User> implements UserService {
	
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
	public void deleteById(long id) {
		this.userDao.deleteById(id);

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
}
