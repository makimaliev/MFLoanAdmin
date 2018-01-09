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
public class FixTermDaoImpl implements FixTermDao {
     
    private static final Logger logger = LoggerFactory.getLogger(FixTermDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public FixTermDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(FixTerm fixTerm) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(fixTerm);
		
		logger.info("FixTerm added == "+fixTerm);
		
	} 


	@Override
	public void edit(FixTerm fixTerm) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(fixTerm);
		
		logger.info("FixTerm edited == "+fixTerm);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		FixTerm fixTerm = (FixTerm) session.load(FixTerm.class, new Long (id));
		if(fixTerm!=null)
		{
			session.delete(fixTerm);
		}
		
		logger.info("FixTerm deleted == "+fixTerm);
		
	}


	@Override
	public FixTerm findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		FixTerm fixTerm = (FixTerm) session.load(FixTerm.class, new Long (id));
		
		logger.info("FixTerm get by id == "+fixTerm);

		return fixTerm ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<FixTerm> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FixTerm> fixTermsList = session.createQuery("from FixTerm").list();
        return fixTermsList;
    }
 

}