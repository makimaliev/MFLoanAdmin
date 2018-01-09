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
public class PersonDaoImpl implements PersonDao {
     
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Person person) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		
		logger.info("Person added == "+person);
		
	} 


	@Override
	public void edit(Person person) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		
		logger.info("Person edited == "+person);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Long (id));
		if(person!=null)
		{
			session.delete(person);
		}
		
		logger.info("Person deleted == "+person);
		
	}


	@Override
	public Person findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Long (id));
		
		logger.info("Person get by id == "+person);

		return person ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        return personsList;
    }
 

}