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
public class EmploymentHistoryEventDaoImpl implements EmploymentHistoryEventDao {
     
    private static final Logger logger = LoggerFactory.getLogger(EmploymentHistoryEventDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public EmploymentHistoryEventDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(EmploymentHistoryEvent employmentHistoryEvent) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employmentHistoryEvent);
		
		logger.info("EmploymentHistoryEvent added == "+employmentHistoryEvent);
		
	} 


	@Override
	public void edit(EmploymentHistoryEvent employmentHistoryEvent) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employmentHistoryEvent);
		
		logger.info("EmploymentHistoryEvent edited == "+employmentHistoryEvent);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistoryEvent employmentHistoryEvent = (EmploymentHistoryEvent) session.load(EmploymentHistoryEvent.class, new Long (id));
		if(employmentHistoryEvent!=null)
		{
			session.delete(employmentHistoryEvent);
		}
		
		logger.info("EmploymentHistoryEvent deleted == "+employmentHistoryEvent);
		
	}


	@Override
	public EmploymentHistoryEvent findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistoryEvent employmentHistoryEvent = (EmploymentHistoryEvent) session.load(EmploymentHistoryEvent.class, new Long (id));
		
		logger.info("EmploymentHistoryEvent get by id == "+employmentHistoryEvent);

		return employmentHistoryEvent ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<EmploymentHistoryEvent> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EmploymentHistoryEvent> employmentHistoryEventsList = session.createQuery("from EmploymentHistoryEvent").list();
        return employmentHistoryEventsList;
    }
 

}