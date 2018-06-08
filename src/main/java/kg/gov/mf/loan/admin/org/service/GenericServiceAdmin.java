package kg.gov.mf.loan.admin.org.service;

import java.util.List;

public interface GenericServiceAdmin<E> {

	void create(E entity);
    List<E> findAll();
    List<E> findAll(int firstResult, int maxResults);
    List<E> findByParam(String param);
    List<E> findByParam(String param, int firstResult, int maxResults);
    E findById(Long id);
    int count();
    void edit(E entity);
    void delete(E entity);

}
