package kg.gov.mf.loan.admin.org.repository;

import kg.gov.mf.loan.admin.org.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> , QueryDslPredicateExecutor {
    List<Organization> findByName(String s);
}
