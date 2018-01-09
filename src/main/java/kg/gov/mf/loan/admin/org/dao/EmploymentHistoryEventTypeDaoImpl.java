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
public class EmploymentHistoryEventTypeDaoImpl implements EmploymentHistoryEventTypeDao {
     
    private static final Logger logger = LoggerFactory.getLogger(EmploymentHistoryEventTypeDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public EmploymentHistoryEventTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(EmploymentHistoryEventType employmentHistoryEventType) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employmentHistoryEventType);
		
		logger.info("EmploymentHistoryEventType added == "+employmentHistoryEventType);
		
	} 


	@Override
	public void edit(EmploymentHistoryEventType employmentHistoryEventType) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employmentHistoryEventType);
		
		logger.info("EmploymentHistoryEventType edited == "+employmentHistoryEventType);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistoryEventType employmentHistoryEventType = (EmploymentHistoryEventType) session.load(EmploymentHistoryEventType.class, new Long (id));
		if(employmentHistoryEventType!=null)
		{
			session.delete(employmentHistoryEventType);
		}
		
		logger.info("EmploymentHistoryEventType deleted == "+employmentHistoryEventType);
		
	}


	@Override
	public EmploymentHistoryEventType findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistoryEventType employmentHistoryEventType = (EmploymentHistoryEventType) session.load(EmploymentHistoryEventType.class, new Long (id));
		
		logger.info("EmploymentHistoryEventType get by id == "+employmentHistoryEventType);

		return employmentHistoryEventType ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<EmploymentHistoryEventType> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EmploymentHistoryEventType> employmentHistoryEventTypesList = session.createQuery("from EmploymentHistoryEventType").list();
        return employmentHistoryEventTypesList;
    }
 

}