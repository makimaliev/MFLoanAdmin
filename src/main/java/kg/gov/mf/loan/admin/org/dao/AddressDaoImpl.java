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
public class AddressDaoImpl implements AddressDao {
     
    private static final Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public AddressDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Address address) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(address);
		
		logger.info("Address added == "+address);
		
	} 


	@Override
	public void edit(Address address) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(address);
		
		logger.info("Address edited == "+address);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Long (id));
		if(address!=null)
		{
			session.delete(address);
		}
		
		logger.info("Address deleted == "+address);
		
	}


	@Override
	public Address findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Long (id));
		
		logger.info("Address get by id == "+address);

		return address ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Address> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addresssList = session.createQuery("from Address").list();
        return addresssList;
    }
 

}