package kg.gov.mf.loan.admin.sys.service;

import java.util.List;


import kg.gov.mf.loan.admin.sys.model.*;

public interface SystemFileService {

	
	
	public void create(SystemFile systemFile);
	
	public void edit(SystemFile systemFile);
	
	public void deleteById(long id);
	
	public SystemFile findById (long id);
	
	public List<SystemFile> findAll();
}
