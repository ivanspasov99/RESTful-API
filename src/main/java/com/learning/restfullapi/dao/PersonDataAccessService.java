package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository("blog")
public class PersonDataAccessService implements Blog {

    private final JdbcTemplate jdbc;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insertPost(Post post) {
        final String sql = "INSERT INTO \"Posts\" (author, note, created_at) VALUES (?, ?, current_timestamp)";

        return jdbc.update(sql, post.getAuthor(), post.getNote());
    }

    @Override
    public List<Post> getPosts() {
        final String sql = "SELECT * FROM \"Posts\" WHERE deleted_at is null";

        return jdbc.query(sql, (res, i) -> getPostData(res));
    }

    @Override
    public Post getPostById(int id) {
        final String sql = "SELECT * FROM \"Posts\" WHERE deleted_at is null and id = " + id;

        Post post;

        try {
            post = jdbc.queryForObject(sql, (resultSet, i) -> getPostData(resultSet));
        } catch (DataAccessException e) {
            return null;
        }

        return post;
    }

    @Override
    public int deletePostById(int id) {
        final String sql = "UPDATE \"Posts\" SET deleted_at = current_timestamp WHERE id =" + id;

        return jdbc.update(sql);
    }

    @Override
    public int updatePostById(int id, Post post) {
        final String sql = "UPDATE \"Posts\" " +
                "SET updated_at = current_timestamp," +
                "author = ?, note = ? WHERE deleted_at is null and id = " + id;

        return jdbc.update(sql, post.getAuthor(), post.getNote());
    }

    private Post getPostData(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        String author = res.getString("author");
        String note = res.getString("note");

        Post post = new Post(id, author, note);

        post.setCreatedAt(res.getTimestamp("created_at"));
        post.setUpdatedAt(res.getTimestamp("updated_at"));
        post.setDeletedAt(res.getTimestamp("deleted_at"));

        return post;
    }
}
