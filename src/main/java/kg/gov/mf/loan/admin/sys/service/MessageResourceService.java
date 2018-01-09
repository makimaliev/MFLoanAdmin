package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface MessageResourceService {

	
	
	public void create(MessageResource messageResource);
	
	public void edit(MessageResource messageResource);
	
	public void deleteById(long id);
	
	public MessageResource findById (long id);
	
	public List<MessageResource> findAll();
}
