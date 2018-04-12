package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import kg.gov.mf.loan.admin.org.model.Staff;
import org.springframework.stereotype.Repository;


import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface UserDao {

	public void create(User user);
	
	public void edit(User user);
	
	public void deleteById(long id);
	
	public User findById (long id);
	 
	public User findByUsername(String username);

	public User findByStaff(Staff staff);
	
	
	public List<User> findAll();

}
