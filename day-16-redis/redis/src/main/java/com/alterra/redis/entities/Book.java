package com.alterra.redis.entities;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Book")
public class Book {
    private String id;
    private String ISBN;
    private String title;
    private String author;
    private String description;
    private String category;

    public Book(String id, String ISBN, String title, String author, String description, String category) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public Book() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}