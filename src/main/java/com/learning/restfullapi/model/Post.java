package com.learning.restfullapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Timestamp createdAt = null;
    private Timestamp updatedAt = null;

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
        return updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedAt(Timestamp date) {
        this.createdAt = date;
    }

    public void setUpdatedAt(Timestamp date) {
        this.updatedAt = date;
    }

    public void setId(int id) {
        this.id = id;
    }
}
