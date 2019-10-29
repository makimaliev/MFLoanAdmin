package kg.gov.mf.loan.admin.sys.dao;

import kg.gov.mf.loan.admin.sys.model.MessageResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageResourceDao {

	public void create(MessageResource messageResource);
	
	public void edit(MessageResource messageResource);
	
	public void deleteById(long id);
	
	public MessageResource findById (long id);
	
	public List<MessageResource> findAll();

	public List<MessageResource> findAll(int limit,String val);

	public List<MessageResource> findAll(int limit);

}
