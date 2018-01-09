package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface ObjectTypeService {

	
	
	public void create(ObjectType objectType);
	
	public void edit(ObjectType objectType);
	
	public void deleteById(long id);
	
	public ObjectType findById (long id);
	
	public ObjectType findByCode (String code);
	
	public List<ObjectType> findAll();
}
