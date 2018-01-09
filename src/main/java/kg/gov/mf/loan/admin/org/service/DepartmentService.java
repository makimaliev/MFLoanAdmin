package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface DepartmentService {

	
	
	public void create(Department department);
	
	public void edit(Department department);
	
	public void deleteById(long id);
	
	public Department findById (long id);
	
	public List<Department> findAll();
}
