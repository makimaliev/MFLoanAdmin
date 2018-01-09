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
public class OrganizationDaoImpl implements OrganizationDao {
     
    private static final Logger logger = LoggerFactory.getLogger(OrganizationDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public OrganizationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Organization organization) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(organization);
		
		logger.info("Organization added == "+organization);
		
	} 


	@Override
	public void edit(Organization organization) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(organization);
		
		logger.info("Organization edited == "+organization);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Organization organization = (Organization) session.load(Organization.class, new Long (id));
		if(organization!=null)
		{
			session.delete(organization);
		}
		
		logger.info("Organization deleted == "+organization);
		
	}


	@Override
	public Organization findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Organization organization = (Organization) session.load(Organization.class, new Long (id));
		
		logger.info("Organization get by id == "+organization);

		return organization ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Organization> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Organization> organizationsList = session.createQuery("from Organization").list();
        System.out.println(organizationsList.toString());
        return organizationsList;
    }
 

}