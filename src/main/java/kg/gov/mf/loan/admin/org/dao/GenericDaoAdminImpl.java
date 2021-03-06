package kg.gov.mf.loan.admin.org.dao;

import kg.gov.mf.loan.admin.org.model.GenericModelAdmin;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.sys.model.User;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public abstract class GenericDaoAdminImpl<E> implements GenericDaoAdmin<E> {

	@Autowired
    protected SessionFactory sessionFactory;
    protected Class<? extends E> entityClass;


    public GenericDaoAdminImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class) pt.getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(E entity) {
        if (isAuditable(entity)){
            ((GenericModelAdmin) entity).setAuCreatedBy(getUser());
            ((GenericModelAdmin) entity).setAuCreatedDate(new Date());
        }
        getCurrentSession().save(entity);
    }

    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public List<E> findAll(int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public List<E> findByParam(String param) {
        return getCurrentSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.desc(param)).list();
    }

    public List<E> findByParam(String param, int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.desc(param));
        return criteria.list();
    }

    public int count()
    {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        ScrollableResults scrollableResults = criteria.scroll();
        scrollableResults.last();
        return  scrollableResults.getRowNumber()+1;
    }

    public E findById(Long id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public void edit(E entity) {
        if (isAuditable(entity)){
            ((GenericModelAdmin) entity).setAuLastModifiedBy(getUser());
            ((GenericModelAdmin) entity).setAuLastModifiedDate(new Date());
        }
        getCurrentSession().update(entity);
    }

    public void delete(E entity) {
        getCurrentSession().delete(entity);
    }

//    public void deleteById(Long id) {
//        getCurrentSession().delete((E) getCurrentSession().get(entityClass, id));
//    }

    boolean isAuditable(E entity) {

        Object[] auditedClass = new Object[]
                {
                        Person.class,
                        Organization.class,
                        User.class
                };

        return Arrays.asList(auditedClass).contains(entity.getClass());
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
