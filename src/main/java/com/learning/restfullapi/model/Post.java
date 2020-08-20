package com.learning.restfullapi.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import java.sql.Timestamp;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue private int id;
    @NonNull private String note;
    @Pattern(regexp = "^[a-zA-Z1-9]+.*$") @NonNull private String author;
    private Timestamp created_at = null;
    private Timestamp updated_at = null;

    public Post() {}

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getAuthor() {
        return author;
    }

    public Timestamp getUpdatedAt() {
        return updated_at;
    }

    public Timestamp getCreatedAt() {
        return created_at;
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

    public void setId(int id) {
        this.id = id;
    }
}
