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
public class VillageDaoImpl implements VillageDao {
     
    private static final Logger logger = LoggerFactory.getLogger(VillageDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public VillageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Village village) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(village);
		
		logger.info("Village added == "+village);
		
	} 


	@Override
	public void edit(Village village) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(village);
		
		logger.info("Village edited == "+village);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Village villageToBeDeleted = (Village) session.load(Village.class, new Long (id));
		if(villageToBeDeleted!=null)
		{
			
			
			Aokmotu aokmotuOfVillageToBeDeleted = (Aokmotu) session.load(Aokmotu.class, villageToBeDeleted.getAokmotu().getId());

			Set <Village> villageList = aokmotuOfVillageToBeDeleted.getVillage();
			
			villageList.remove((Village) villageToBeDeleted);
			
			aokmotuOfVillageToBeDeleted.setVillage(villageList);
			
			session.update(aokmotuOfVillageToBeDeleted);
			
			
			//session.delete(village);
		}
		
		logger.info("Village deleted == "+villageToBeDeleted);
		
	}


	@Override
	public Village findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Village village = (Village) session.load(Village.class, new Long (id));
		
		logger.info("Village get by id == "+village);

		return village ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Village> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Village> villagesList = session.createQuery("from Village").list();
        return villagesList;
    }
 

}