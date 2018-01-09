package kg.gov.mf.loan.admin.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kg.gov.mf.loan.admin.org.dao.*;
import kg.gov.mf.loan.admin.org.model.*;

@Service
public class BankDataServiceJpaImpl implements BankDataService {
	
	@Autowired
    private BankDataDao bankDataDao;
 
    public void setBankDataDao(BankDataDao bankDataDao) {
        this.bankDataDao = bankDataDao;
    }
 
    

	@Override
	@Transactional	
	public void create(BankData bankData) {
		this.bankDataDao.create(bankData);
		
	}

	@Override
	@Transactional	
	public void edit(BankData bankData) {
		this.bankDataDao.edit(bankData);
		
	}

	@Override
	@Transactional	
	public void deleteById(long id) {
		this.bankDataDao.deleteById(id);
		
	}

	@Override
	@Transactional	
	public BankData findById(long id) {
		return this.bankDataDao.findById(id);
	}

	@Override
    @Transactional
    public List<BankData> findAll() {
        return this.bankDataDao.findAll();
    }
}
