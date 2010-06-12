package com.abria.webapp.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import com.abria.webapp.model.Person;

public class PersonDaoTest extends BaseDaoTestCase
{
	@Autowired
    private PersonDao personDao;
	
	@Test
	public void testFindPersonByLastName() throws Exception {
	    List<Person> people = personDao.findByLastName("Raible");
	    assertTrue(people.size() > 0);
	}
	
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemovePerson() throws Exception 
	{
	    Person person = new Person();
	    person = (Person)populate(person);
//	    person.setFirstName("Country");
//	    person.setLastName("Bry");

	    person = personDao.save(person);
	    flush();

	    person = personDao.get(person.getId());

	    assertEquals("Country", person.getFirstName());
	    assertNotNull(person.getId());

	    log.debug("removing person...");

	    personDao.remove(person.getId());
	    flush();

	    // should throw DataAccessException
	    personDao.get(person.getId());
	}

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
