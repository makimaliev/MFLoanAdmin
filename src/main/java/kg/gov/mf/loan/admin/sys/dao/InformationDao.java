package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface InformationDao {

	public void create(Information information);
	
	public void edit(Information information);
	
	public void deleteById(long id);
	
	public Information findById (long id);
	
	public List<Information> findAll();

	public List<Information> findInformationBySystemObjectTypeIdAndSystemObjectId(long systemObjectTypeId,long systemObjectId);


}
