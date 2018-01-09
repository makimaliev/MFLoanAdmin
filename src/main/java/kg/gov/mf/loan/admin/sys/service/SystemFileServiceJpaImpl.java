package kg.gov.mf.loan.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.sys.dao.*;
import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class SystemFileServiceJpaImpl implements SystemFileService {
	
	@Autowired
    private SystemFileDao systemFileDao;
 
    public void setSystemFileDao(SystemFileDao systemFileDao) {
        this.systemFileDao = systemFileDao;
    }
 
    

	@Override
	@Transactional	
	public void create(SystemFile systemFile) {
		this.systemFileDao.create(systemFile);
		
	}

	@Override
	@Transactional	
	public void edit(SystemFile systemFile) {
		this.systemFileDao.edit(systemFile);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.systemFileDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public SystemFile findById(long id) {
		return this.systemFileDao.findById(id);
	}

	@Override
    @Transactional
    public List<SystemFile> findAll() {
        return this.systemFileDao.findAll();
    }
}
