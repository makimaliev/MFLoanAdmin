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
public class ObjectFieldDaoImpl implements ObjectFieldDao {
     
    private static final Logger logger = LoggerFactory.getLogger(ObjectFieldDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public ObjectFieldDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(ObjectField objectField) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(objectField);
		
		logger.info("ObjectField added == "+objectField);
		
	} 


	@Override
	public void edit(ObjectField objectField) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(objectField);
		
		logger.info("ObjectField edited == "+objectField);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectField objectField = (ObjectField) session.load(ObjectField.class, new Long (id));
		if(objectField!=null)
		{
			session.delete(objectField);
		}
		
		logger.info("ObjectField deleted == "+objectField);
		
	}


	@Override
	public ObjectField findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		ObjectField objectField = (ObjectField) session.load(ObjectField.class, new Long (id));
		
		logger.info("ObjectField get by id == "+objectField);

		return objectField ;
	}

	@Override
	public ObjectField findByCode(String code) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(ObjectField.class);
		criteria.add(Restrictions.eq("code", code));

		return (ObjectField) criteria.uniqueResult() ;		

	}
	
    @SuppressWarnings("unchecked")
    @Override
    public List<ObjectField> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ObjectField> objectFieldsList = session.createQuery("from ObjectField").list();
        return objectFieldsList;
    }
 

}