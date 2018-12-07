package kg.gov.mf.loan.admin.org.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kg.gov.mf.loan.admin.org.model.*;
 
@Repository("organizationDao")
public class OrganizationDaoImpl extends GenericDaoAdminImpl<Organization>implements OrganizationDao {

    @Override
    public Organization findById(Long id)
    {
        Organization organization = super.findById(id);

        Hibernate.initialize(organization.getIdentityDoc());
        Hibernate.initialize(organization.getIdentityDoc().getIdentityDocDetails());
        Hibernate.initialize(organization.getIdentityDoc().getIdentityDocType());
        Hibernate.initialize(organization.getIdentityDoc().getIdentityDocGivenBy());
        Hibernate.initialize(organization.getContact());
        Hibernate.initialize(organization.getAddress());
        Hibernate.initialize(organization.getAddress().getAddressDetails());
        Hibernate.initialize(organization.getAddress().getVillage());
        Hibernate.initialize(organization.getAddress().getDistrict());
        Hibernate.initialize(organization.getAddress().getAokmotu());
        Hibernate.initialize(organization.getAddress().getRegion());
        Hibernate.initialize(organization.getAddress());
        Hibernate.initialize(organization.getOrgForm());
        Hibernate.initialize(organization.getBankData());
        Hibernate.initialize(organization.getDepartment());


        return organization;
    }
}