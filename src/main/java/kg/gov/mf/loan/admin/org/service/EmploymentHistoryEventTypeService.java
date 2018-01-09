package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface EmploymentHistoryEventTypeService {

	
	
	public void create(EmploymentHistoryEventType employmentHistoryEventType);
	
	public void edit(EmploymentHistoryEventType employmentHistoryEventType);
	
	public void deleteById(long id);
	
	public EmploymentHistoryEventType findById (long id);
	
	public List<EmploymentHistoryEventType> findAll();
}
