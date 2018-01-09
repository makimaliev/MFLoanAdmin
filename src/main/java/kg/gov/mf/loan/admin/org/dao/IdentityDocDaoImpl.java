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
public class IdentityDocDaoImpl implements IdentityDocDao {
     
    private static final Logger logger = LoggerFactory.getLogger(IdentityDocDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public IdentityDocDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(IdentityDoc identityDoc) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identityDoc);
		
		logger.info("IdentityDoc added == "+identityDoc);
		
	} 


	@Override
	public void edit(IdentityDoc identityDoc) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identityDoc);
		
		logger.info("IdentityDoc edited == "+identityDoc);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDoc identityDoc = (IdentityDoc) session.load(IdentityDoc.class, new Long (id));
		if(identityDoc!=null)
		{
			session.delete(identityDoc);
		}
		
		logger.info("IdentityDoc deleted == "+identityDoc);
		
	}


	@Override
	public IdentityDoc findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDoc identityDoc = (IdentityDoc) session.load(IdentityDoc.class, new Long (id));
		
		logger.info("IdentityDoc get by id == "+identityDoc);

		return identityDoc ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<IdentityDoc> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<IdentityDoc> identityDocsList = session.createQuery("from IdentityDoc").list();
        return identityDocsList;
    }
 

}