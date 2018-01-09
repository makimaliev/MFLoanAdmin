package kg.gov.mf.loan.admin.sys.dao;

import java.util.List;
 




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.sys.model.*;
 
@Repository
public class PermissionDaoImpl implements PermissionDao {
     
    private static final Logger logger = LoggerFactory.getLogger(PermissionDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public PermissionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Permission permission) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(permission);
		
		logger.info("Permission added == "+permission);
		
	} 


	@Override
	public void edit(Permission permission) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(permission);
		
		logger.info("Permission edited == "+permission);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Permission permission = (Permission) session.load(Permission.class, new Long (id));
		if(permission!=null)
		{
			session.delete(permission);
		}
		
		logger.info("Permission deleted == "+permission);
		
	}


	@Override
	public Permission findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Permission permission = (Permission) session.load(Permission.class, new Long (id));
		
		logger.info("Permission get by id == "+permission);

		return permission ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Permission> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Permission> permissionsList = session.createQuery("from Permission").list();
        return permissionsList;
    }
 

}