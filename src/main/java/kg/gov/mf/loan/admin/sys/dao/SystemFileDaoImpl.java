package kg.gov.mf.loan.admin.sys.dao;

import kg.gov.mf.loan.admin.sys.model.Attachment;
import kg.gov.mf.loan.admin.sys.model.SystemFile;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
 
@Repository
public class SystemFileDaoImpl implements SystemFileDao {
     
    private static final Logger logger = LoggerFactory.getLogger(SystemFileDaoImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    
    @Autowired
    public SystemFileDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
 



	@Override
	public void create(SystemFile systemFile) {
		
		Session session = this.sessionFactory.getCurrentSession();
		systemFile.setAuCreatedBy(getUser());
		systemFile.setAuCreatedDate(new Date());
		session.persist(systemFile);
		
		logger.info("SystemFile added == "+systemFile);
		
	} 


	@Override
	public void edit(SystemFile systemFile) {
		
		
		Session session = this.sessionFactory.getCurrentSession();

		systemFile.setAuLastModifiedBy(getUser());
		systemFile.setAuLastModifiedDate(new Date());
		session.update(systemFile);
		
		logger.info("SystemFile edited == "+systemFile);
	}


	@Override
	public void deleteById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SystemFile systemFile = (SystemFile) session.load(SystemFile.class, new Long (id));
		if(systemFile!=null)
		{
			
			
			Attachment attachment = (Attachment) session.load(Attachment.class, systemFile.getAttachment().getId());

			Set <SystemFile> systemFileList = attachment.getSystemFile();
			
			systemFileList.remove((SystemFile) systemFile);
			
			attachment.setSystemFile(systemFileList);
			
			session.update(attachment);
			
			
			//session.delete(systemFile);
		}
		
		logger.info("SystemFile deleted == "+systemFile);
		
	}


	@Override
	public SystemFile findById(long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		SystemFile systemFile = (SystemFile) session.load(SystemFile.class, new Long (id));

		Hibernate.initialize(systemFile.getAttachment());

		return systemFile ;
	}


	
    @SuppressWarnings("unchecked")
    @Override
    public List<SystemFile> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SystemFile> systemFilesList = session.createQuery("from SystemFile").list();
        return systemFilesList;
    }

	private String getUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		else
		{
			return authentication.getName();
		}
	}
    
}