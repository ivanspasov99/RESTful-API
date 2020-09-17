package com.learning.restfullapi.controller;

import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

// manages CRUD

@RestController
@RequestMapping
@CrossOrigin(maxAge = 3600)
public class PostController {
    private final PostsService postsService;

    @Autowired // it is declared by default, only on constructors
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("api/post")
    public Post insertPost(@Valid @RequestBody Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new PersistenceException();
        }
        return postsService.insertPost(post);
    }

    @PutMapping("api/post/{id}")
    public Post updatePostById(@PathVariable("id") int id, @Valid @RequestBody Post post, BindingResult bindingResult) throws PostNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new PersistenceException();
        }
        return postsService.updatePostById(id, post);
    }

    @DeleteMapping("api/post/{id}")
    public Post deletePostById(@PathVariable("id") int id) throws PostNotFoundException {
        return postsService.deletePostById(id);
    }

    @GetMapping("api/post")
    public List<Post> getPosts() {
        return postsService.getPosts();
    }

    @GetMapping("api/post/{id}")
    public Optional<Post> getPostById(@PathVariable("id") int id) throws PostNotFoundException {
        return postsService.getPostById(id);
    }
}
