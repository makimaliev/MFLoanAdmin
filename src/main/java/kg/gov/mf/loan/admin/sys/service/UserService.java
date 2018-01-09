package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface UserService {

	
	
	public void create(User user);
	
	public void edit(User user);
	
	public void deleteById(long id);
	
	public User findById (long id);
	
	public User findByUsername (String username);
	
	
	public List<User> findAll();
}
