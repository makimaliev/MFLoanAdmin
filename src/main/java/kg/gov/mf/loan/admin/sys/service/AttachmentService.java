package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface AttachmentService {

	
	
	public void create(Attachment attachment);
	
	public void edit(Attachment attachment);
	
	public void deleteById(long id);
	
	public Attachment findById (long id);
	
	public List<Attachment> findAll();
}
