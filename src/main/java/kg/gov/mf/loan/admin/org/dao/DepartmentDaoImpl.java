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
public class DepartmentDaoImpl implements DepartmentDao {
     
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(Department department) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(department);
		
		logger.info("Department added == "+department);
		
	} 


	@Override
	public void edit(Department department) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(department);
		
		logger.info("Department edited == "+department);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Department department = (Department) session.load(Department.class, new Long (id));
		if(department!=null)
		{
			
			Organization organization = (Organization) session.load(Organization.class, department.getOrganization().getId());

			Set <Department> departmentList = organization.getDepartment();
			
			departmentList.remove((Department) department);
			
			organization.setDepartment(departmentList);
			
			session.update(organization);
			
			
			//session.delete(department);
		}
		
		logger.info("Department deleted == "+department);
		
	}


	@Override
	public Department findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Department department = (Department) session.load(Department.class, new Long (id));
		
		logger.info("Department get by id == "+department);

		return department ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<Department> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentsList = session.createQuery("from Department").list();
        return departmentsList;
    }
 

}