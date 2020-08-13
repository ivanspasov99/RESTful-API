package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Person;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeDB implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getALlPeople() {
        return DB;
    }

    @Override
    public Person getPersonById(UUID id) {
        for (Person p: DB) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        Person p = getPersonById(id);
        if(p != null) {
            DB.remove(p);
            return 1;
        }
        return 0;
    }

    // to check it, because youtuber does not do such thing, only DB.set(index, newPerson)
    // which does not work, because newPerson does not have specific id, because it is not initialized
    // only casted form JSON data
    @Override
    public void updatePersonById(UUID id, Person newPerson) {
        Person person = getPersonById(id);

        person.setName(newPerson.getName());
    }

}
