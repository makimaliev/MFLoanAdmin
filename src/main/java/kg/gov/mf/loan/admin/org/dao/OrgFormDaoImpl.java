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
public class OrgFormDaoImpl implements OrgFormDao {
     
    private static final Logger logger = LoggerFactory.getLogger(OrgFormDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public OrgFormDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(OrgForm orgForm) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(orgForm);
		
		logger.info("OrgForm added == "+orgForm);
		
	} 


	@Override
	public void edit(OrgForm orgForm) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(orgForm);
		
		logger.info("OrgForm edited == "+orgForm);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		OrgForm orgForm = (OrgForm) session.load(OrgForm.class, new Long (id));
		if(orgForm!=null)
		{
			session.delete(orgForm);
		}
		
		logger.info("OrgForm deleted == "+orgForm);
		
	}


	@Override
	public OrgForm findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		OrgForm orgForm = (OrgForm) session.load(OrgForm.class, new Long (id));
		
		logger.info("OrgForm get by id == "+orgForm);

		return orgForm ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<OrgForm> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<OrgForm> orgFormsList = session.createQuery("from OrgForm").list();
        return orgFormsList;
    }
 

}