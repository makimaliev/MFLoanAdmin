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
public class RoleDaoImpl implements RoleDao {
     
    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Role role) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
		
		logger.info("Role added == "+role);
		
	} 


	@Override
	public void edit(Role role) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(role);
		
		logger.info("Role edited == "+role);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, new Long (id));
		if(role!=null)
		{
			session.delete(role);
		}
		
		logger.info("Role deleted == "+role);
		
	}


	@Override
	public Role findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, new Long (id));
		
		logger.info("Role get by id == "+role);

		return role ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> rolesList = session.createQuery("from Role").list();
        return rolesList;
    }
 

}