package com.learning.restfullapi.service;

import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.repository.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        // if there are no posts?

        return postsRepository.findAll();
    }

    public Optional<Post> getPostById(int id) throws PostNotFoundException {
        Optional<Post> post = postsRepository.findById(id);

        validatePostNotFoundException(post);

        return post;
    }

    public void deletePostById(int id) throws PostNotFoundException {
        Optional<Post> post = postsRepository.findById(id);

        validatePostNotFoundException(post);

        postsRepository.deleteById(id);
    }

    public Post updatePostById(int id, Post newPost) throws PostNotFoundException {
        Optional<Post> post = postsRepository.findById(id);

        validatePostNotFoundException(post);

        newPost.setId(id);
        newPost.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        newPost.setCreatedAt(post.get().getCreatedAt());

        return postsRepository.save(newPost);
    }

    private void validatePostNotFoundException(Optional<Post> post) throws PostNotFoundException {
        if (post.isEmpty()) {
            throw new PostNotFoundException("There is no such post");
        }
    }
}
