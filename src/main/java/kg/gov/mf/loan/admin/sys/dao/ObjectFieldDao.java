package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface ObjectFieldDao {

	public void create(ObjectField objectField);
	
	public void edit(ObjectField objectField);
	
	public void deleteById(long id);
	
	public ObjectField findById (long id);
	
	public ObjectField findByCode (String code);	
	
	public List<ObjectField> findAll();

}
