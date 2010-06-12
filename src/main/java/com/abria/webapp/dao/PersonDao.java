package com.abria.webapp.dao;

import org.appfuse.dao.GenericDao;
import com.abria.webapp.model.Person;

import java.util.List;

public interface PersonDao extends GenericDao<Person, Long> {
    public List<Person> findByLastName(String lastName);
}