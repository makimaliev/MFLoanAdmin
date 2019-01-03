package kg.gov.mf.loan.admin.org.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

		Hibernate.initialize(staff.getDepartment());
//		Hibernate.initialize(staff.getUser());
		Hibernate.initialize(staff.getPosition());
		Hibernate.initialize(staff.getOrganization());
		Hibernate.initialize(staff.getEmploymentHistory());
		Hibernate.initialize(staff.getPerson());

		return staff ;
	}


	@Override
	public Staff findByOrganizationAndDepartment(Organization organization, Department department) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.createAlias("organization", "organization");
		criteria.createAlias("department", "department");
		criteria.createAlias("position", "position");
		criteria.add(Restrictions.eq("organization.id", organization.getId()));
		criteria.add(Restrictions.eq("department.id", department.getId()));
		criteria.setMaxResults(1);

		criteria.add(Restrictions.eq("position.id", department.getPosition().iterator().next().getId()));

		Staff staff = (Staff) criteria.uniqueResult();

		Hibernate.initialize(staff.getDepartment());
//		Hibernate.initialize(staff.getUser());
		Hibernate.initialize(staff.getPosition());
		Hibernate.initialize(staff.getOrganization());
		Hibernate.initialize(staff.getEmploymentHistory());
		Hibernate.initialize(staff.getPerson());


		return staff ;

	}

	@Override
	public List<Staff> findAllByDepartment(Department department) {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Staff.class);

		criteria.createAlias("department", "department");
		criteria.add(Restrictions.eq("department.id", department.getId()));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		return criteria.list();
	}

	
    @SuppressWarnings("unchecked")
    @Override
    public List<Staff> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Staff> staffsList = session.createQuery("from Staff").list();
        return staffsList;
    }
 

}