package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface DepartmentDao {

	public void create(Department department);
	
	public void edit(Department department);
	
	public void deleteById(long id);
	
	public Department findById (long id);
	
	public List<Department> findAll();

}
