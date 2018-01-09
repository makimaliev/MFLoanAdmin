package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface PositionDao {

	public void create(Position position);
	
	public void edit(Position position);
	
	public void deleteById(long id);
	
	public Position findById (long id);
	
	public List<Position> findAll();

}
