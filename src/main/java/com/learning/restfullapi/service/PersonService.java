package com.learning.restfullapi.service;

import com.learning.restfullapi.dao.Blog;
import com.learning.restfullapi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// Business logic for PersonService

@Service
public class PersonService {
    private final Blog blog;

    @Autowired
    public PersonService(@Qualifier("blog") Blog post) {
        this.blog = post;
    }

    public int insertPost(Post post) {
        return blog.insertPost(post);
    }

    public List<Post> getPosts() {
        return blog.getPosts();
    }

    public Post getPostById(int id) {
        return blog.getPostById(id);
    }

    public int deletePostById(int id) {
        return blog.deletePostById(id);
    }

    public void updatePostById(int id, Post post) {
        blog.updatePostById(id, post);
    }
}
