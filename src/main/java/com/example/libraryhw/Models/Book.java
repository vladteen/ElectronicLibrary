package com.example.libraryhw.Models;

public class Book {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean agree) {
        inStock = agree;
    }

    public String getHasABook() {
        return hasABook;
    }

    public void setHasABook(String hasABook) {
        this.hasABook = hasABook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String author;
    private String yearOfIssue;
    private String publisher;
    private boolean inStock;
    private String hasABook;
    private int id;

}
