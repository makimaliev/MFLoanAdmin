package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface ValidationTermDao {

	public void create(ValidationTerm validationTerm);
	
	public void edit(ValidationTerm validationTerm);
	
	public void deleteById(long id);
	
	public ValidationTerm findById (long id);
	
	public List<ValidationTerm> findAll();

}
