package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface RegionDao {

	public void create(Region region);
	
	public void edit(Region region);
	
	public void deleteById(long id);
	
	public Region findById (long id);
	
	public List<Region> findAll();

}
