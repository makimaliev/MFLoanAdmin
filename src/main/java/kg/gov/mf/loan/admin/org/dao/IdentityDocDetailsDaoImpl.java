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
public class IdentityDocDetailsDaoImpl implements IdentityDocDetailsDao {
     
    private static final Logger logger = LoggerFactory.getLogger(IdentityDocDetailsDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public IdentityDocDetailsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(IdentityDocDetails identityDocDetails) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identityDocDetails);
		
		logger.info("IdentityDocDetails added == "+identityDocDetails);
		
	} 


	@Override
	public void edit(IdentityDocDetails identityDocDetails) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identityDocDetails);
		
		logger.info("IdentityDocDetails edited == "+identityDocDetails);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocDetails identityDocDetails = (IdentityDocDetails) session.load(IdentityDocDetails.class, new Long (id));
		if(identityDocDetails!=null)
		{
			session.delete(identityDocDetails);
		}
		
		logger.info("IdentityDocDetails deleted == "+identityDocDetails);
		
	}


	@Override
	public IdentityDocDetails findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocDetails identityDocDetails = (IdentityDocDetails) session.load(IdentityDocDetails.class, new Long (id));
		
		logger.info("IdentityDocDetails get by id == "+identityDocDetails);

		return identityDocDetails ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<IdentityDocDetails> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<IdentityDocDetails> identityDocDetailssList = session.createQuery("from IdentityDocDetails").list();
        return identityDocDetailssList;
    }
 

}