package com.learning.restfullapi.controller;

import com.learning.restfullapi.model.Posts;
import com.learning.restfullapi.service.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

// manages CRUD

@RestController
@RequestMapping("api/post")
public class PersonController {
    private final PostsService postsService;

    @Autowired // it is declared by default, only on constructors
    public PersonController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping
    public void insertPost(@RequestBody Posts posts) {
        postsService.insertPost(posts);
    }

    @PutMapping(value = "{id}")
    public void updatePostById(@PathVariable("id") int id, @RequestBody Posts posts) {
        postsService.updatePostById(id, posts);
    }

    @DeleteMapping(value = "{id}")
    public void deletePostById(@PathVariable("id") int id) {
        postsService.deletePostById(id);
    }

    @GetMapping
    public List<Posts> getPosts() {
        return postsService.getPosts();
    }

    @GetMapping(value = "{id}")
    public Optional<Posts> getPostById(@PathVariable("id") int id) {
        return postsService.getPostById(id);
    }


}
