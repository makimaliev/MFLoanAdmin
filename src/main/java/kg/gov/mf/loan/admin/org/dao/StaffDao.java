package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface StaffDao {

	public void create(Staff staff);
	
	public void edit(Staff staff);
	
	public void deleteById(long id);
	
	public Staff findById (long id);
	
	public List<Staff> findAll();

}
