package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface ObjectTypeDao {

	public void create(ObjectType objectType);
	
	public void edit(ObjectType objectType);
	
	public void deleteById(long id);
	
	public ObjectType findById (long id);
	
	public ObjectType findByCode (String code);
	
	public List<ObjectType> findAll();

}
