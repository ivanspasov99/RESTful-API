package com.learning.restfullapi.dao;

import com.learning.restfullapi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
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
        final String sql = "SELECT * FROM \"Posts\"";

        return jdbc.query(sql, (res, i) -> getPostData(res));
    }

    @Override
    public Post getPostById(int id) {
        final String sql = "SELECT * FROM \"Posts\" WHERE id = " + id;

        Post post = jdbc.queryForObject(sql, (resultSet, i) -> getPostData(resultSet));
        return post;
    }

    @Override
    public int deletePostById(int id) {
        return 0;
    }

    @Override
    public void updatePostById(int id, Post post) {

    }

    private Post getPostData(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        String author = res.getString("author");
        String note = res.getString("note");

        Post post = new Post(id, author, note);

        post.setCreatedAt(res.getDate("created_at"));
        post.setUpdatedAt(res.getDate("updated_at"));
        post.setDeletedAt(res.getDate("deleted_at"));

        return post;
    }
}
