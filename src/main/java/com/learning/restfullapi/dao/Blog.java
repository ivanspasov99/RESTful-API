package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Post;

import java.util.List;


// database enter interface

public interface Blog {

    int insertPost(Post post);

    List<Post> getPosts();

    Post getPostById(int id);

    int deletePostById(int id);

    void updatePostById(int id, Post post);
}
