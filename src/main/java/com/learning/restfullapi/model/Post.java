package com.learning.restfullapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Post {

    private final int id;
    private String note;
    private String author;
    @JsonProperty("created_at")
    private Date created_at = null;
    @JsonProperty("updated_at")
    private Date updated_at = null;
    @JsonProperty("deleted_at")
    private Date deleted_at = null;

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

    public void setCreatedAt(Date date) {
        this.created_at = date;
    }

    public void setUpdatedAt(Date date) {
        this.updated_at = date;
    }

    public void setDeletedAt(Date deleted_at) {
        this.deleted_at = deleted_at;
    }
}
