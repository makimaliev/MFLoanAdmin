package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import kg.gov.mf.loan.admin.org.model.*;

public interface AokmotuService {

	
	public void create(Aokmotu aokmotu);
	
	public void edit(Aokmotu aokmotu);
	
	public void deleteById(long id);
	
	public Aokmotu findById (long id);
	
	public List<Aokmotu> findAll();	
	
}
