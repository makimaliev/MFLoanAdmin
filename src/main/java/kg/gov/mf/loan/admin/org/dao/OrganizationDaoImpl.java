package kg.gov.mf.loan.admin.org.dao;

import java.util.List;


import org.hibernate.Criteria;
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

}