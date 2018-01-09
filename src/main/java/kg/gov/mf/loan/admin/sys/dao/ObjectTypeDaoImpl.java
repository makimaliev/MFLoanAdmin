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
public class ObjectTypeDaoImpl implements ObjectTypeDao {
     
    private static final Logger logger = LoggerFactory.getLogger(ObjectTypeDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public ObjectTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(ObjectType objectType) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(objectType);
		
		logger.info("ObjectType added == "+objectType);
		
	} 


	@Override
	public void edit(ObjectType objectType) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(objectType);
		
		logger.info("ObjectType edited == "+objectType);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectType objectType = (ObjectType) session.load(ObjectType.class, new Long (id));
		if(objectType!=null)
		{
			session.delete(objectType);
		}
		
		logger.info("ObjectType deleted == "+objectType);
		
	}


	@Override
	public ObjectType findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectType objectType = (ObjectType) session.load(ObjectType.class, new Long (id));
		
		logger.info("ObjectType get by id == "+objectType);

		return objectType ;
	}
	
	@Override
	public ObjectType findByCode(String code) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(ObjectType.class);
		criteria.add(Restrictions.eq("code", code));

		return (ObjectType) criteria.uniqueResult() ;		

	}	


	
    @SuppressWarnings("unchecked")
    @Override
    public List<ObjectType> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ObjectType> objectTypesList = session.createQuery("from ObjectType").list();
        return objectTypesList;
    }
 

}