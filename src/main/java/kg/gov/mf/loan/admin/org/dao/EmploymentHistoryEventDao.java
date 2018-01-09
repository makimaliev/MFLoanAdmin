package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface EmploymentHistoryEventDao {

	public void create(EmploymentHistoryEvent employmentHistoryEvent);
	
	public void edit(EmploymentHistoryEvent employmentHistoryEvent);
	
	public void deleteById(long id);
	
	public EmploymentHistoryEvent findById (long id);
	
	public List<EmploymentHistoryEvent> findAll();

}
