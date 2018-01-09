package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import kg.gov.mf.loan.admin.org.model.*;

public interface EmploymentHistoryService {

	
	public void create(EmploymentHistory employmentHistory);
	
	public void edit(EmploymentHistory employmentHistory);
	
	public void deleteById(long id);
	
	public EmploymentHistory findById (long id);
	
	public List<EmploymentHistory> findAll();	
	
}
