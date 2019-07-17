package kg.gov.mf.loan.admin.sys.service;

import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.org.service.GenericServiceAdmin;
import kg.gov.mf.loan.admin.sys.model.User;

public interface UserService extends GenericServiceAdmin<User> {

	public void deleteById(long id);
	
	public User findByUsername (String username);

	public User findByStaff (Staff staff);

	public User findByDepartment (Department department);

	public User findByOrganization (Organization organization);

	public User findByPerson (Person person);
	

}
