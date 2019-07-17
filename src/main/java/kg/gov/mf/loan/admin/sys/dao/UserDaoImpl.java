package kg.gov.mf.loan.admin.sys.dao;

import kg.gov.mf.loan.admin.org.dao.GenericDaoAdminImpl;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.sys.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class UserDaoImpl extends GenericDaoAdminImpl<User> implements UserDao {
     
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
	public void deleteById(long id) {

		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long (id));
		if(user!=null)
		{
			session.delete(user);
		}

		logger.info("User deleted == "+user);

	}

    public User findByUsername(String username) {
        
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));

		User user = (User)criteria.uniqueResult();

		Hibernate.initialize(user.getStaff());
		Hibernate.initialize(user.getSupervisorTerms());
		Hibernate.initialize(user.getRoles());


		return user;
    
    }

	public User findByStaff(Staff staff) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);
		criteria.createAlias("staff", "staff");
		criteria.add(Restrictions.eq("staff.id", staff.getId()));

		User user = (User)criteria.uniqueResult();

		Hibernate.initialize(user.getStaff());
		Hibernate.initialize(user.getSupervisorTerms());
		Hibernate.initialize(user.getRoles());


		return user;

	}
}