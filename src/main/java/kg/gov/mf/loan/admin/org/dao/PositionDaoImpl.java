package kg.gov.mf.loan.admin.org.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

		Hibernate.initialize(position.getDepartment());

		return position ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Position> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Position> positionsList = session.createQuery("from Position").list();
        return positionsList;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findByDepartment(Department department) {



		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Position.class);

		criteria.add(Restrictions.eq("department", department));


		List<Position> positionsList = criteria.list();
		return positionsList;

	}


}