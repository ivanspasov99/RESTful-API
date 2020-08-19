package com.learning.restfullapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;


public class Post {

    private final int id;
    private String note;
    private String author;
    @JsonProperty("created_at")
    private Timestamp created_at = null;
    @JsonProperty("updated_at")
    private Timestamp updated_at = null;
    @JsonProperty("deleted_at")
    private Timestamp deleted_at = null;

    public Post(@JsonProperty("id") int id, @JsonProperty("author") String author, @JsonProperty("note") String note) {
        this.id = id;
        this.author = author;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getAuthor() {
        return author;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedAt(Timestamp date) {
        this.created_at = date;
    }

    public void setUpdatedAt(Timestamp date) {
        this.updated_at = date;
    }

    public void setDeletedAt(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
}
