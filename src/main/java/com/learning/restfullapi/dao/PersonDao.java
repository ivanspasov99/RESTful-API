package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

// database enter interface

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getALlPeople();

    Person getPersonById(UUID id);

    int deletePersonById(UUID id);

    void updatePersonById(UUID id, Person person);
}
