package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface ValidationTermService {

	
	
	public void create(ValidationTerm validationTerm);
	
	public void edit(ValidationTerm validationTerm);
	
	public void deleteById(long id);
	
	public ValidationTerm findById (long id);
	
	public List<ValidationTerm> findAll();
}
