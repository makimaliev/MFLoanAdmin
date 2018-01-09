package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface ObjectEventService {

	
	
	public void create(ObjectEvent objectEvent);
	
	public void edit(ObjectEvent objectEvent);
	
	public void deleteById(long id);
	
	public ObjectEvent findById (long id);
	
	public List<ObjectEvent> findAll();
}
