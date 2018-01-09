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
public class PhoneDaoImpl implements PhoneDao {
     
    private static final Logger logger = LoggerFactory.getLogger(PhoneDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public PhoneDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Phone phone) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(phone);
		
		logger.info("Phone added == "+phone);
		
	} 


	@Override
	public void edit(Phone phone) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(phone);
		
		logger.info("Phone edited == "+phone);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Phone phone = (Phone) session.load(Phone.class, new Long (id));
		if(phone!=null)
		{
			session.delete(phone);
		}
		
		logger.info("Phone deleted == "+phone);
		
	}


	@Override
	public Phone findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Phone phone = (Phone) session.load(Phone.class, new Long (id));
		
		logger.info("Phone get by id == "+phone);

		return phone ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Phone> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Phone> phonesList = session.createQuery("from Phone").list();
        return phonesList;
    }
 

}