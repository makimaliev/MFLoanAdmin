package kg.gov.mf.loan.admin.org.service;

import java.util.List;


import kg.gov.mf.loan.admin.org.model.*;

public interface PositionService {

	
	
	public void create(Position position);
	
	public void edit(Position position);
	
	public void deleteById(long id);
	
	public Position findById (long id);
	
	public List<Position> findAll();
}
