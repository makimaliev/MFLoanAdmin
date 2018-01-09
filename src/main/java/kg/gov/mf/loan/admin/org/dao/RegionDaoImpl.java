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
public class RegionDaoImpl implements RegionDao {
     
    private static final Logger logger = LoggerFactory.getLogger(RegionDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public RegionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Region region) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(region);
		
		logger.info("Region added == "+region);
		
	} 


	@Override
	public void edit(Region region) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(region);
		
		logger.info("Region edited == "+region);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Region region = (Region) session.load(Region.class, new Long (id));
		if(region!=null)
		{
			session.delete(region);
		}
		
		logger.info("Region deleted == "+region);
		
	}


	@Override
	public Region findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Region region = (Region) session.load(Region.class, new Long (id));
		
		logger.info("Region get by id == "+region);

		return region ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Region> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Region> regionsList = session.createQuery("from Region").list();
        return regionsList;
    }
 

}