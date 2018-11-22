package kg.gov.mf.loan.admin.org.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;
 
@Repository
public class DistrictDaoImpl implements DistrictDao {
     
    private static final Logger logger = LoggerFactory.getLogger(DistrictDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public DistrictDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(District district) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(district);
		
		logger.info("District added == "+district);
		
	} 


	@Override
	public void edit(District district) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(district);
		
		logger.info("District edited == "+district);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		District district = (District) session.load(District.class, new Long (id));
		if(district!=null)
		{
			
			Region region = (Region) session.load(Region.class, district.getRegion().getId());

			Set <District> districtList = region.getDistrict();
			
			districtList.remove((District) district);
			
			region.setDistrict(districtList);
			
			session.update(region);
			
			//session.delete(district);
		}
		
		logger.info("District deleted == "+district);
		
	}


	@Override
	public District findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		District district = (District) session.load(District.class, new Long (id));

		Hibernate.initialize(district.getAokmotu());
		
		logger.info("District get by id == "+district);

		return district ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<District> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<District> districtsList = session.createQuery("from District").list();
        return districtsList;
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<District> findByRegion(Region region) {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(District.class);

		criteria.add(Restrictions.eq("region", region));


		List<District> districtsList = criteria.list();
		return districtsList;
	}

}