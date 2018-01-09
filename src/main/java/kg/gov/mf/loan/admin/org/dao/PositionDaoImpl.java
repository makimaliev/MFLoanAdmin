package kg.gov.mf.loan.admin.org.dao;

import java.util.List;
 




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;
 
@Repository
public class PositionDaoImpl implements PositionDao {
     
    private static final Logger logger = LoggerFactory.getLogger(PositionDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public PositionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Position position) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(position);
		
		logger.info("Position added == "+position);
		
	} 


	@Override
	public void edit(Position position) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(position);
		
		logger.info("Position edited == "+position);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Position position = (Position) session.load(Position.class, new Long (id));
		if(position!=null)
		{
			session.delete(position);
		}
		
		logger.info("Position deleted == "+position);
		
	}


	@Override
	public Position findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Position position = (Position) session.load(Position.class, new Long (id));
		
		logger.info("Position get by id == "+position);

		return position ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Position> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Position> positionsList = session.createQuery("from Position").list();
        return positionsList;
    }
 

}