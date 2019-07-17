package kg.gov.mf.loan.admin.sys.dao;

import kg.gov.mf.loan.admin.org.dao.GenericDaoAdmin;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.sys.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends GenericDaoAdmin<User> {

	public void deleteById(long id);
	 
	public User findByUsername(String username);

	public User findByStaff(Staff staff);


}
