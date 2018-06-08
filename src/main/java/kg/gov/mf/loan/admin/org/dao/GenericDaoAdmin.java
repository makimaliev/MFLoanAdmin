package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

public interface GenericDaoAdmin<E> {

	void create(E entity);
    List<E> findAll();
    List<E> findAll(int firstResult, int maxResults);
    List<E> findByParam(String param);
    List<E> findByParam(String param, int firstResult, int maxResults);
    int count();
    E findById(Long id);

    void edit(E entity);

    void delete(E entity);
//    void deleteById(Long id);
}
