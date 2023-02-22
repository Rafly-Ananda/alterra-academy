package com.alterra.redis.entities;

public class RegisterBookRequest {
    private String ISBN;
    private String title;
    private String author;
    private String description;
    private String category;

    public RegisterBookRequest(String ISBN, String title, String author, String description, String category) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public RegisterBookRequest() {

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
