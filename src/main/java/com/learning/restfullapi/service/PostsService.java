package com.learning.restfullapi.service;

import com.learning.restfullapi.repository.PostsRepository;
import com.learning.restfullapi.model.Posts;

import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;

// Business logic

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts insertPost(Posts posts) {
        posts.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return postsRepository.save(posts);
    }

    public List<Posts> getPosts() {
        return postsRepository.findAll();
    }

    public Optional<Posts> getPostById(int id) {
        return postsRepository.findById(id);
    }

    public void deletePostById(int id) {
        postsRepository.deleteById(id);
    }

    public Posts updatePostById(int id, Posts newPosts) {
        // needs improvement, with status code and checking if post exist
        newPosts.setId(id);
        newPosts.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return postsRepository.save(newPosts);
    }
}
