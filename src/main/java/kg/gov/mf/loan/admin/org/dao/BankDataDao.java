package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface BankDataDao {

	public void create(BankData bankData);
	
	public void edit(BankData bankData);
	
	public void deleteById(long id);
	
	public BankData findById (long id);
	
	public List<BankData> findAll();

}
