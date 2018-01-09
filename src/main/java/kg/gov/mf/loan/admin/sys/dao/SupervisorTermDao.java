package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface SupervisorTermDao {

	public void create(SupervisorTerm supervisorTerm);
	
	public void edit(SupervisorTerm supervisorTerm);
	
	public void deleteById(long id);
	
	public SupervisorTerm findById (long id);
	
	public List<SupervisorTerm> findAll();

}
