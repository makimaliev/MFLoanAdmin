package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface ObjectFieldService {

	
	
	public void create(ObjectField objectField);
	
	public void edit(ObjectField objectField);
	
	public void deleteById(long id);
	
	public ObjectField findById (long id);
	
	public ObjectField findByCode (String code);
	
	public List<ObjectField> findAll();
}
