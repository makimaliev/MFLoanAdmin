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
public class IdentityDocGivenByDaoImpl implements IdentityDocGivenByDao {
     
    private static final Logger logger = LoggerFactory.getLogger(IdentityDocGivenByDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public IdentityDocGivenByDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(IdentityDocGivenBy identityDocGivenBy) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identityDocGivenBy);
		
		logger.info("IdentityDocGivenBy added == "+identityDocGivenBy);
		
	} 


	@Override
	public void edit(IdentityDocGivenBy identityDocGivenBy) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identityDocGivenBy);
		
		logger.info("IdentityDocGivenBy edited == "+identityDocGivenBy);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocGivenBy identityDocGivenBy = (IdentityDocGivenBy) session.load(IdentityDocGivenBy.class, new Long (id));
		if(identityDocGivenBy!=null)
		{
			session.delete(identityDocGivenBy);
		}
		
		logger.info("IdentityDocGivenBy deleted == "+identityDocGivenBy);
		
	}


	@Override
	public IdentityDocGivenBy findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		IdentityDocGivenBy identityDocGivenBy = (IdentityDocGivenBy) session.load(IdentityDocGivenBy.class, new Long (id));
		
		logger.info("IdentityDocGivenBy get by id == "+identityDocGivenBy);

		return identityDocGivenBy ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<IdentityDocGivenBy> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<IdentityDocGivenBy> identityDocGivenBysList = session.createQuery("from IdentityDocGivenBy").list();
        return identityDocGivenBysList;
    }
 

}