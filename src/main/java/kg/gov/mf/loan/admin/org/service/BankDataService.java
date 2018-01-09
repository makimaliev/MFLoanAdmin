package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface BankDataService {

	
	
	public void create(BankData bankData);
	
	public void edit(BankData bankData);
	
	public void deleteById(long id);
	
	public BankData findById (long id);
	
	public List<BankData> findAll();
}
