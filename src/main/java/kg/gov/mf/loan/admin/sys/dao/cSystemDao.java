package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface cSystemDao {

	public void create(cSystem cSystem);
	
	public void edit(cSystem cSystem);
	
	public void deleteById(long id);
	
	public cSystem findById (long id);
	
	public List<cSystem> findAll();

}
