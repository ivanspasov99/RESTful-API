package com.learning.restfullapi.service;

import com.learning.restfullapi.exceptions.PostNotFoundException;
import com.learning.restfullapi.model.Post;
import com.learning.restfullapi.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Post deletePostById(int id) throws PostNotFoundException {
        Optional<Post> optionalPost = postsRepository.findById(id);

        Post post = validatePostNotFoundException(optionalPost);

        postsRepository.deleteById(id);

        return post;
    }

    public Post updatePostById(int id, Post newPost) throws PostNotFoundException {
        Optional<Post> optionalPost = postsRepository.findById(id);

        Post post = validatePostNotFoundException(optionalPost);

        post.setAuthor(newPost.getAuthor());
        post.setNote(newPost.getNote());
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return postsRepository.saveAndFlush(post);
    }

    private Post validatePostNotFoundException(Optional<Post> post) throws PostNotFoundException {
        if (post.isEmpty()) {
            throw new PostNotFoundException("There is no such post");
        }
        return post.get();
    }
}
