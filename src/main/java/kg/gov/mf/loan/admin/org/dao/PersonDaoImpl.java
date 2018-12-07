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

@Repository("personDao")
public class PersonDaoImpl extends GenericDaoAdminImpl<Person> implements PersonDao {

    @Override
    public Person findById(Long id)
    {
        Person person = super.findById(id);

        Hibernate.initialize(person.getIdentityDoc());
        Hibernate.initialize(person.getIdentityDoc().getIdentityDocDetails());
        Hibernate.initialize(person.getIdentityDoc().getIdentityDocType());
        Hibernate.initialize(person.getIdentityDoc().getIdentityDocGivenBy());
        Hibernate.initialize(person.getContact());
        Hibernate.initialize(person.getAddress());
        Hibernate.initialize(person.getAddress().getAddressDetails());
        Hibernate.initialize(person.getAddress().getVillage());
        Hibernate.initialize(person.getAddress().getDistrict());
        Hibernate.initialize(person.getAddress().getAokmotu());
        Hibernate.initialize(person.getAddress().getRegion());
        Hibernate.initialize(person.getAddress());

        return person;
    }

}