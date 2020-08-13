package com.learning.restfullapi.api;

import com.learning.restfullapi.model.Person;
import com.learning.restfullapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// manages CRUD


@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired // it is declared by default, only on constructors
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("api/insertPerson")
    public void insertPerson(@RequestBody Person person) {
        personService.insertPerson(person);
    }

    @PutMapping(path = "api/updatePerson/{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }

    @GetMapping(path = "api/getAllPeople")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "api/getPerson/{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "api/deletePerson/{id}")
    public int deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }


}
