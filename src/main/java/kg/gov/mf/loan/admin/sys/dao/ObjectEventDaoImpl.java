package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;
 




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;
 
@Repository
public class ObjectEventDaoImpl implements ObjectEventDao {
     
    private static final Logger logger = LoggerFactory.getLogger(ObjectEventDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public ObjectEventDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(ObjectEvent objectEvent) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(objectEvent);
		
		logger.info("ObjectEvent added == "+objectEvent);
		
	} 


	@Override
	public void edit(ObjectEvent objectEvent) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(objectEvent);
		
		logger.info("ObjectEvent edited == "+objectEvent);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectEvent objectEvent = (ObjectEvent) session.load(ObjectEvent.class, new Long (id));
		if(objectEvent!=null)
		{
			session.delete(objectEvent);
		}
		
		logger.info("ObjectEvent deleted == "+objectEvent);
		
	}


	@Override
	public ObjectEvent findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectEvent objectEvent = (ObjectEvent) session.load(ObjectEvent.class, new Long (id));
		
		logger.info("ObjectEvent get by id == "+objectEvent);

		return objectEvent ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<ObjectEvent> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ObjectEvent> objectEventsList = session.createQuery("from ObjectEvent").list();
        return objectEventsList;
    }
 

}