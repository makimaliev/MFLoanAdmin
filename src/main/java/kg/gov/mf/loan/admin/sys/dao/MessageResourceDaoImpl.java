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
public class MessageResourceDaoImpl implements MessageResourceDao {
     
    private static final Logger logger = LoggerFactory.getLogger(MessageResourceDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public MessageResourceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(MessageResource messageResource) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(messageResource);
		
		logger.info("MessageResource added == "+messageResource);
		
	} 


	@Override
	public void edit(MessageResource messageResource) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(messageResource);
		
		logger.info("MessageResource edited == "+messageResource);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		MessageResource messageResource = (MessageResource) session.load(MessageResource.class, new Long (id));
		if(messageResource!=null)
		{
			session.delete(messageResource);
		}
		
		logger.info("MessageResource deleted == "+messageResource);
		
	}


	@Override
	public MessageResource findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		MessageResource messageResource = (MessageResource) session.load(MessageResource.class, new Long (id));
		
		logger.info("MessageResource get by id == "+messageResource);

		return messageResource ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<MessageResource> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<MessageResource> messageResourcesList = session.createQuery("from MessageResource").list();
        return messageResourcesList;
    }
 

}