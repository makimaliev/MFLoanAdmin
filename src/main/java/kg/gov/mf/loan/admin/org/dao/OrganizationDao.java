package kg.gov.mf.loan.admin.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;

@Repository
public interface OrganizationDao extends  GenericDaoAdmin<Organization>{

	public List<Organization> findLast100();

}
