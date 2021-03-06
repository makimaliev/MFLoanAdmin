package kg.gov.mf.loan.admin.org.repository;

import kg.gov.mf.loan.admin.org.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameContains(String q);
}
