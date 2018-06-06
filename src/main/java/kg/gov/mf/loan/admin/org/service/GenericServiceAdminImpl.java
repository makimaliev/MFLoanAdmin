package kg.gov.mf.loan.admin.org.service;

import kg.gov.mf.loan.admin.org.dao.GenericDaoAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceAdminImpl<E> implements GenericServiceAdmin<E> {
	
	@Autowired
    protected GenericDaoAdmin<E> dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(E entity) {
	    dao.create(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll() {
    	return dao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll(int firstResult, int maxResults) {
        return dao.findAll(firstResult ,maxResults);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findByParam(String param) {
        return dao.findByParam(param);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findByParam(String param, int firstResult, int maxResults) {
        return dao.findByParam(param, firstResult, maxResults);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public int count() {
        return dao.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findById(Long id) {
    	return dao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void edit(E entity) {
    	dao.edit(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(E entity) {
    	dao.delete(entity);
    }

}
