package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface AokmotuDao {

	
	public void create(Aokmotu aokmotu);
	
	public void edit(Aokmotu aokmotu);
	
	public void deleteById(long id);
	
	public Aokmotu findById (long id);
	
	public List<Aokmotu> findAll();

}
