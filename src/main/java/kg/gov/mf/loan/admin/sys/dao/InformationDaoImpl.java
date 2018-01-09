package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kg.gov.mf.loan.admin.sys.model.*;


 
@Repository
public class InformationDaoImpl implements InformationDao {
     
    private static final Logger logger = LoggerFactory.getLogger(InformationDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public InformationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Information information) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(information);
		
		logger.info("Information added == "+information);
		
	} 


	@Override
	public void edit(Information information) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(information);
		
		logger.info("Information edited == "+information);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Information information = (Information) session.load(Information.class, new Long (id));
		if(information!=null)
		{
			session.delete(information);
		}
		
		logger.info("Information deleted == "+information);
		
	}


	@Override
	public Information findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Information information = (Information) session.load(Information.class, new Long (id));
		
		logger.info("Information get by id == "+information);

		return information ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Information> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Information> informationsList = session.createQuery("from Information").list();
        return informationsList;
    }
 
    
	@Override
	public List<Information> findInformationBySystemObjectTypeIdAndSystemObjectId(long systemObjectTypeId,long systemObjectId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Information.class);
		criteria.add(Restrictions.eq("systemObjectTypeId", systemObjectTypeId));
		criteria.add(Restrictions.eq("systemObjectId", systemObjectId));


		return criteria.list() ;
	}

}