package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbc;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getALlPeople() {
        final String sql = "SELECT * FROM schema.persons";

        return jdbc.query(sql, (res, i) -> {
           int id = res.getByte("id");
           String name = res.getString("name");
           return new Person(UUID.randomUUID(), name);
       });
    }

    @Override
    public Person getPersonById(UUID id) {
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public void updatePersonById(UUID id, Person person) {

    }
}
