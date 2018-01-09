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
public class AddressDetailsDaoImpl implements AddressDetailsDao {
     
    private static final Logger logger = LoggerFactory.getLogger(AddressDetailsDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public AddressDetailsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(AddressDetails addressDetails) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(addressDetails);
		
		logger.info("AddressDetails added == "+addressDetails);
		
	} 


	@Override
	public void edit(AddressDetails addressDetails) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(addressDetails);
		
		logger.info("AddressDetails edited == "+addressDetails);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		AddressDetails addressDetails = (AddressDetails) session.load(AddressDetails.class, new Long (id));
		if(addressDetails!=null)
		{
			session.delete(addressDetails);
		}
		
		logger.info("AddressDetails deleted == "+addressDetails);
		
	}


	@Override
	public AddressDetails findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		AddressDetails addressDetails = (AddressDetails) session.load(AddressDetails.class, new Long (id));
		
		logger.info("AddressDetails get by id == "+addressDetails);

		return addressDetails ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<AddressDetails> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AddressDetails> addressDetailssList = session.createQuery("from AddressDetails").list();
        return addressDetailssList;
    }
 

}