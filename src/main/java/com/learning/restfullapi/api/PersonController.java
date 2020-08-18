package com.learning.restfullapi.api;

import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// manages CRUD

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired // it is declared by default, only on constructors
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("api/insertPost")
    public void insertPost(@RequestBody Post post) {
        personService.insertPost(post);
    }

    @PutMapping(path = "api/updatePost/{id}")
    public void updatePostById(@PathVariable("id") int id, @RequestBody Post post) {
        personService.updatePostById(id, post);
    }

    @GetMapping(path = "api/getPosts")
    public List<Post> getPosts() {
        return personService.getPosts();
    }

    @GetMapping(path = "api/getPost/{id}")
    public Post getPostById(@PathVariable("id") int id) {
        return personService.getPostById(id);
    }

    @DeleteMapping(path = "api/deletePost/{id}")
    public int deletePostById(@PathVariable("id") int id) {
        return personService.deletePostById(id);
    }


}
