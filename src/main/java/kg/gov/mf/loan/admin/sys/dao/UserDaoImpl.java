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
public class UserDaoImpl implements UserDao {
     
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(User user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		System.out.println(user.getRoles().toString());
		session.persist(user);
		
		logger.info("User added == "+user);
		
	} 


	@Override
	public void edit(User user) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		
		logger.info("User edited == "+user);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long (id));
		if(user!=null)
		{
			session.delete(user);
		}
		
		logger.info("User deleted == "+user);
		
	}


	@Override
	public User findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long (id));
		
		logger.info("User get by id == "+user);

		return user ;
	}

    public User findByUsername(String username) {
        
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));


		return (User)criteria.uniqueResult() ;
    
    }
	
	
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();
        return usersList;
    }
 

}