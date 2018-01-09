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
public class cSystemDaoImpl implements cSystemDao {
     
    private static final Logger logger = LoggerFactory.getLogger(cSystemDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public cSystemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(cSystem cSystem) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cSystem);
		
		logger.info("CSystem added == "+cSystem);
		
	} 


	@Override
	public void edit(cSystem cSystem) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cSystem);
		
		logger.info("CSystem edited == "+cSystem);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		cSystem cSystem = (cSystem) session.load(cSystem.class, new Long (id));
		if(cSystem!=null)
		{
			session.delete(cSystem);
		}
		
		logger.info("CSystem deleted == "+cSystem);
		
	}


	@Override
	public cSystem findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		cSystem cSystem = (cSystem) session.load(cSystem.class, new Long (id));
		
		logger.info("cSystem get by id == "+cSystem);

		return cSystem ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<cSystem> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<cSystem> cSystemsList = session.createQuery("from cSystem").list();
        return cSystemsList;
    }
 

}