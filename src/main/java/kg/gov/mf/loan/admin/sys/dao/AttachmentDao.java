package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface AttachmentDao {

	public void create(Attachment attachment);
	
	public void edit(Attachment attachment);
	
	public void deleteById(long id);
	
	public Attachment findById (long id);
	
	public List<Attachment> findAll();

}
