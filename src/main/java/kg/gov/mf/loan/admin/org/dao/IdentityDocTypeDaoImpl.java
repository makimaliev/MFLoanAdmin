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
public class IdentityDocTypeDaoImpl implements IdentityDocTypeDao {
     
    private static final Logger logger = LoggerFactory.getLogger(IdentityDocTypeDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public IdentityDocTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(IdentityDocType identityDocType) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identityDocType);
		
		logger.info("IdentityDocType added == "+identityDocType);
		
	} 


	@Override
	public void edit(IdentityDocType identityDocType) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identityDocType);
		
		logger.info("IdentityDocType edited == "+identityDocType);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocType identityDocType = (IdentityDocType) session.load(IdentityDocType.class, new Long (id));
		if(identityDocType!=null)
		{
			session.delete(identityDocType);
		}
		
		logger.info("IdentityDocType deleted == "+identityDocType);
		
	}


	@Override
	public IdentityDocType findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocType identityDocType = (IdentityDocType) session.load(IdentityDocType.class, new Long (id));
		
		logger.info("IdentityDocType get by id == "+identityDocType);

		return identityDocType ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<IdentityDocType> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<IdentityDocType> identityDocTypesList = session.createQuery("from IdentityDocType").list();
        return identityDocTypesList;
    }
 

}