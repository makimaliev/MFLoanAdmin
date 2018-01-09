package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface EmploymentHistoryEventTypeDao {

	public void create(EmploymentHistoryEventType employmentHistoryEventType);
	
	public void edit(EmploymentHistoryEventType employmentHistoryEventType);
	
	public void deleteById(long id);
	
	public EmploymentHistoryEventType findById (long id);
	
	public List<EmploymentHistoryEventType> findAll();

}
