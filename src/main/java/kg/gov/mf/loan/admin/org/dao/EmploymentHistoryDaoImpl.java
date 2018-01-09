package kg.gov.mf.loan.admin.org.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;
 
@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDao {
     
    private static final Logger logger = LoggerFactory.getLogger(EmploymentHistoryDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public EmploymentHistoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(EmploymentHistory employmentHistory) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employmentHistory);
		
		logger.info("EmploymentHistory added == "+employmentHistory);
		
	} 


	@Override
	public void edit(EmploymentHistory employmentHistory) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employmentHistory);
		
		logger.info("EmploymentHistory edited == "+employmentHistory);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistory employmentHistory = (EmploymentHistory) session.load(EmploymentHistory.class, new Long (id));
		if(employmentHistory!=null)
		{
			
			session.delete(employmentHistory);
		}
		
		logger.info("EmploymentHistory deleted == "+employmentHistory);
		
	}


	@Override
	public EmploymentHistory findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EmploymentHistory employmentHistory = (EmploymentHistory) session.load(EmploymentHistory.class, new Long (id));
		
		logger.info("EmploymentHistory get by id == "+employmentHistory);

		return employmentHistory ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<EmploymentHistory> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EmploymentHistory> employmentHistorysList = session.createQuery("from EmploymentHistory").list();
        return employmentHistorysList;
    }
 

}