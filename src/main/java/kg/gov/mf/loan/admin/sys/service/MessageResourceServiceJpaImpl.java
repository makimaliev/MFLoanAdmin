package kg.gov.mf.loan.admin.sys.service;

import kg.gov.mf.loan.admin.sys.dao.MessageResourceDao;
import kg.gov.mf.loan.admin.sys.model.MessageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageResourceServiceJpaImpl implements MessageResourceService {
	
	@Autowired
    private MessageResourceDao messageResourceDao;
 
    public void setMessageResourceDao(MessageResourceDao messageResourceDao) {
        this.messageResourceDao = messageResourceDao;
    }
 
    

	@Override
	@Transactional	
	public void create(MessageResource messageResource) {
		this.messageResourceDao.create(messageResource);
		
	}

	@Override
	@Transactional	
	public void edit(MessageResource messageResource) {
		this.messageResourceDao.edit(messageResource);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.messageResourceDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public MessageResource findById(long id) {
		return this.messageResourceDao.findById(id);
	}

	@Override
    @Transactional
    public List<MessageResource> findAll() {
        return this.messageResourceDao.findAll();
    }

	@Override
	@Transactional
	public List<MessageResource> findAll(int limit,String val) {
		return this.messageResourceDao.findAll(limit,val);
	}

	@Override
	@Transactional
	public List<MessageResource> findAll(int limit) {
		return this.messageResourceDao.findAll(limit);
	}
}
