package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface EmploymentHistoryEventService {

	
	
	public void create(EmploymentHistoryEvent employmentHistoryEvent);
	
	public void edit(EmploymentHistoryEvent employmentHistoryEvent);
	
	public void deleteById(long id);
	
	public EmploymentHistoryEvent findById (long id);
	
	public List<EmploymentHistoryEvent> findAll();
}
