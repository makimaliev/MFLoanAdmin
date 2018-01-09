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
public class SupervisorTermDaoImpl implements SupervisorTermDao {
     
    private static final Logger logger = LoggerFactory.getLogger(SupervisorTermDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public SupervisorTermDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(SupervisorTerm supervisorTerm) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(supervisorTerm);
		
		logger.info("SupervisorTerm added == "+supervisorTerm);
		
	} 


	@Override
	public void edit(SupervisorTerm supervisorTerm) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(supervisorTerm);
		
		logger.info("SupervisorTerm edited == "+supervisorTerm);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SupervisorTerm supervisorTerm = (SupervisorTerm) session.load(SupervisorTerm.class, new Long (id));
		if(supervisorTerm!=null)
		{
			session.delete(supervisorTerm);
		}
		
		logger.info("SupervisorTerm deleted == "+supervisorTerm);
		
	}


	@Override
	public SupervisorTerm findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SupervisorTerm supervisorTerm = (SupervisorTerm) session.load(SupervisorTerm.class, new Long (id));
		
		logger.info("SupervisorTerm get by id == "+supervisorTerm);

		return supervisorTerm ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<SupervisorTerm> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SupervisorTerm> supervisorTermsList = session.createQuery("from SupervisorTerm").list();
        return supervisorTermsList;
    }
 

}