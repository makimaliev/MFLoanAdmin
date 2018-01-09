package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;

@Repository
public interface SystemFileDao {

	public void create(SystemFile systemFile);
	
	public void edit(SystemFile systemFile);
	
	public void deleteById(long id);
	
	public SystemFile findById (long id);
	
	public List<SystemFile> findAll();
	
	

}
