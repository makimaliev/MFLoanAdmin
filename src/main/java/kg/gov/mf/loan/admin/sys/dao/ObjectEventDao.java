package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface ObjectEventDao {

	public void create(ObjectEvent objectEvent);
	
	public void edit(ObjectEvent objectEvent);
	
	public void deleteById(long id);
	
	public ObjectEvent findById (long id);
	
	public List<ObjectEvent> findAll();

}
