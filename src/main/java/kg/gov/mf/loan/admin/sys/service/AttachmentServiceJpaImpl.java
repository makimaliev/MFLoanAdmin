package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class AttachmentServiceJpaImpl implements AttachmentService {
	
	@Autowired
    private AttachmentDao attachmentDao;
 
    public void setAttachmentDao(AttachmentDao attachmentDao) {
        this.attachmentDao = attachmentDao;
    }
 
    

	@Override
	@Transactional	
	public void create(Attachment attachment) {
		this.attachmentDao.create(attachment);
		
	}

	@Override
	@Transactional	
	public void edit(Attachment attachment) {
		this.attachmentDao.edit(attachment);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.attachmentDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public Attachment findById(long id) {
		return this.attachmentDao.findById(id);
	}

	@Override
    @Transactional
    public List<Attachment> findAll() {
        return this.attachmentDao.findAll();
    }
}
