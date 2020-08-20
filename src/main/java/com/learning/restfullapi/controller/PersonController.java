package com.learning.restfullapi.controller;

import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.service.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

// manages CRUD

@RestController
@RequestMapping
public class PersonController {
    private final PostsService postsService;

    @Autowired // it is declared by default, only on constructors
    public PersonController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("api/post")
    public Post insertPost(@RequestBody Post post) {
        return postsService.insertPost(post);
    }

    @PutMapping("api/post/{id}")
    public void updatePostById(@PathVariable("id") int id, @RequestBody Post post) throws PostNotFoundException {
        postsService.updatePostById(id, post);
    }

    @DeleteMapping("api/post/{id}")
    public void deletePostById(@PathVariable("id") int id) {
        postsService.deletePostById(id);
    }

    @GetMapping("api/post")
    public List<Post> getPosts() {
        return postsService.getPosts();
    }

    @GetMapping("api/post/{id}")
    public Optional<Post> getPostById(@PathVariable("id") int id) {
        return postsService.getPostById(id);
    }


}
