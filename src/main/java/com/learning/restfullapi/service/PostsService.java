package com.learning.restfullapi.service;

import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.repository.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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

    public Post insertPost(Post post) {
        post.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return postsRepository.save(post);
    }

    public List<Post> getPosts() {
        return postsRepository.findAll();
    }

    public Optional<Post> getPostById(int id) {
        return postsRepository.findById(id);
    }

    public void deletePostById(int id) {
        postsRepository.deleteById(id);
    }

    public Post updatePostById(int id, Post newPost) throws PostNotFoundException {
        if(postsRepository.findById(id).isEmpty()) {
            throw new PostNotFoundException("There is no such post");
        }

        newPost.setId(id);
        newPost.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return postsRepository.save(newPost);
    }
}
