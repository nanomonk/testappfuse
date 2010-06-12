package com.abria.webapp.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

import com.abria.webapp.dao.PersonDao;
import com.abria.webapp.model.Person;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHibernate() {
        super(Person.class);
    }

    public List<Person> findByLastName(String lastName) {
        return getHibernateTemplate().find("from Person where lastName=?", lastName);
    }
}