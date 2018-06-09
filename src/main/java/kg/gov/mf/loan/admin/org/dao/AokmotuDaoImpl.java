package kg.gov.mf.loan.admin.org.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;
 
@Repository
public class AokmotuDaoImpl implements AokmotuDao {
     
    private static final Logger logger = LoggerFactory.getLogger(AokmotuDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public AokmotuDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Aokmotu aokmotu) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(aokmotu);
		
		logger.info("Aokmotu added == "+aokmotu);
		
	} 


	@Override
	public void edit(Aokmotu aokmotu) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(aokmotu);
		
		logger.info("Aokmotu edited == "+aokmotu);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Aokmotu aokmotuToBeDeleted = (Aokmotu) session.load(Aokmotu.class, new Long (id));
		if(aokmotuToBeDeleted!=null)
		{
			
			
			
			District districtOfAokmotuToBeDeleted = (District) session.load(District.class, aokmotuToBeDeleted.getDistrict().getId());

			Set <Aokmotu> aokmotuList = districtOfAokmotuToBeDeleted.getAokmotu();
			
			aokmotuList.remove((Aokmotu) aokmotuToBeDeleted);
			
			districtOfAokmotuToBeDeleted.setAokmotu(aokmotuList);
			
			session.update(districtOfAokmotuToBeDeleted);
			
			
			
			//session.delete(aokmotu);
		}
		
		logger.info("Aokmotu deleted == "+aokmotuToBeDeleted);
		
	}


	@Override
	public Aokmotu findById(long id) {

		Session session = this.sessionFactory.getCurrentSession();
		Aokmotu aokmotu = (Aokmotu) session.load(Aokmotu.class, new Long (id));

		logger.info("Aokmotu get by id == "+aokmotu);

		return aokmotu ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Aokmotu> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Aokmotu> aokmotusList = session.createQuery("from Aokmotu").list();
        return aokmotusList;
    }



	@SuppressWarnings("unchecked")
	@Override
	public List<Aokmotu> findByDistrict(District district) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Aokmotu.class);

		criteria.add(Restrictions.eq("district", district));

		return criteria.list();

	}





	@Override
	public Aokmotu findByName(String name) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Aokmotu.class);
		Aokmotu aokmotu = (Aokmotu)criteria.add(Restrictions.eq("name", name)).list().get(0);

		logger.info("Aokmotu get by id == "+aokmotu);

		return aokmotu ;
	}
}