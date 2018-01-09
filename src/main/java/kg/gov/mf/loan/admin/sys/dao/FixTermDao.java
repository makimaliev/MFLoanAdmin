package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface FixTermDao {

	public void create(FixTerm fixTerm);
	
	public void edit(FixTerm fixTerm);
	
	public void deleteById(long id);
	
	public FixTerm findById (long id);
	
	public List<FixTerm> findAll();

}
