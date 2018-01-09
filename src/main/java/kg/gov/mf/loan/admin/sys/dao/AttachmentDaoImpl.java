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
public class AttachmentDaoImpl implements AttachmentDao {
     
    private static final Logger logger = LoggerFactory.getLogger(AttachmentDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public AttachmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Attachment attachment) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(attachment);
		
		logger.info("Attachment added == "+attachment);
		
	} 


	@Override
	public void edit(Attachment attachment) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(attachment);
		
		logger.info("Attachment edited == "+attachment);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Attachment attachment = (Attachment) session.load(Attachment.class, new Long (id));
		if(attachment!=null)
		{
			session.delete(attachment);
		}
		
		logger.info("Attachment deleted == "+attachment);
		
	}


	@Override
	public Attachment findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Attachment attachment = (Attachment) session.load(Attachment.class, new Long (id));
		
		logger.info("Attachment get by id == "+attachment);

		return attachment ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Attachment> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Attachment> attachmentsList = session.createQuery("from Attachment").list();
        return attachmentsList;
    }
 

}