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
public class ContactDaoImpl implements ContactDao {
     
    private static final Logger logger = LoggerFactory.getLogger(ContactDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public ContactDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Contact contact) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(contact);
		
		logger.info("Contact added == "+contact);
		
	} 


	@Override
	public void edit(Contact contact) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(contact);
		
		logger.info("Contact edited == "+contact);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Contact contact = (Contact) session.load(Contact.class, new Long (id));
		if(contact!=null)
		{
			session.delete(contact);
		}
		
		logger.info("Contact deleted == "+contact);
		
	}


	@Override
	public Contact findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Contact contact = (Contact) session.load(Contact.class, new Long (id));
		
		logger.info("Contact get by id == "+contact);

		return contact ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contact> contactsList = session.createQuery("from Contact").list();
        return contactsList;
    }
 

}