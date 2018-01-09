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
public class StaffDaoImpl implements StaffDao {
     
    private static final Logger logger = LoggerFactory.getLogger(StaffDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public StaffDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Staff staff) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(staff);
		
		logger.info("Staff added == "+staff);
		
	} 


	@Override
	public void edit(Staff staff) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(staff);
		
		logger.info("Staff edited == "+staff);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.load(Staff.class, new Long (id));
		if(staff!=null)
		{
			session.delete(staff);
		}
		
		logger.info("Staff deleted == "+staff);
		
	}


	@Override
	public Staff findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.load(Staff.class, new Long (id));
		
		logger.info("Staff get by id == "+staff);

		return staff ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Staff> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Staff> staffsList = session.createQuery("from Staff").list();
        return staffsList;
    }
 

}