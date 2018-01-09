package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface DistrictDao {

	public void create(District district);
	
	public void edit(District district);
	
	public void deleteById(long id);
	
	public District findById (long id);
	
	public List<District> findAll();

}
