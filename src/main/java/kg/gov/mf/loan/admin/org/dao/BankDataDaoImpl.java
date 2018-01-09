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
public class BankDataDaoImpl implements BankDataDao {
     
    private static final Logger logger = LoggerFactory.getLogger(BankDataDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public BankDataDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(BankData bankData) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bankData);
		
		logger.info("BankData added == "+bankData);
		
	} 


	@Override
	public void edit(BankData bankData) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bankData);
		
		logger.info("BankData edited == "+bankData);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		BankData bankData = (BankData) session.load(BankData.class, new Long (id));
		if(bankData!=null)
		{
			
			Organization organization = (Organization) session.load(Organization.class, bankData.getOrganization().getId());

			Set <BankData> bankDataList = organization.getBankData();
			
			bankDataList.remove((BankData) bankData);
			
			organization.setBankData(bankDataList);
			
			session.update(organization);
			
			
			
			//session.delete(bankData);
		}
		
		logger.info("BankData deleted == "+bankData);
		
	}


	@Override
	public BankData findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		BankData bankData = (BankData) session.load(BankData.class, new Long (id));
		
		logger.info("BankData get by id == "+bankData);

		return bankData ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<BankData> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<BankData> bankDatasList = session.createQuery("from BankData").list();
        return bankDatasList;
    }
 

}