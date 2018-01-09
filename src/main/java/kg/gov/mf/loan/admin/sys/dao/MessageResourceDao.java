package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface MessageResourceDao {

	public void create(MessageResource messageResource);
	
	public void edit(MessageResource messageResource);
	
	public void deleteById(long id);
	
	public MessageResource findById (long id);
	
	public List<MessageResource> findAll();

}
