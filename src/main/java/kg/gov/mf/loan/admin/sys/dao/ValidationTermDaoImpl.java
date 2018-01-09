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
public class ValidationTermDaoImpl implements ValidationTermDao {
     
    private static final Logger logger = LoggerFactory.getLogger(ValidationTermDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public ValidationTermDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(ValidationTerm validationTerm) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(validationTerm);
		
		logger.info("ValidationTerm added == "+validationTerm);
		
	} 


	@Override
	public void edit(ValidationTerm validationTerm) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(validationTerm);
		
		logger.info("ValidationTerm edited == "+validationTerm);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ValidationTerm validationTerm = (ValidationTerm) session.load(ValidationTerm.class, new Long (id));
		if(validationTerm!=null)
		{
			session.delete(validationTerm);
		}
		
		logger.info("ValidationTerm deleted == "+validationTerm);
		
	}


	@Override
	public ValidationTerm findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ValidationTerm validationTerm = (ValidationTerm) session.load(ValidationTerm.class, new Long (id));
		
		logger.info("ValidationTerm get by id == "+validationTerm);

		return validationTerm ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<ValidationTerm> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ValidationTerm> validationTermsList = session.createQuery("from ValidationTerm").list();
        return validationTermsList;
    }
 

}