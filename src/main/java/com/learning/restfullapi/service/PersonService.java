package com.learning.restfullapi.service;

import com.learning.restfullapi.dao.PersonDao;
import com.learning.restfullapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// Business logic for PersonService

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.getALlPeople();
    }

    public Person getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
