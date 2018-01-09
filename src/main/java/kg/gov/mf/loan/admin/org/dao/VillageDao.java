package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface VillageDao {

	
	public void create(Village village);
	
	public void edit(Village village);
	
	public void deleteById(long id);
	
	public Village findById (long id);
	
	public List<Village> findAll();

}
