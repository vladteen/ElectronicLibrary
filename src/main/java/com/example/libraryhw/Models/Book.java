package com.example.libraryhw.Models;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.validation.constraints.*;

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

    public Date getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Date yearOfIssue) {
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

    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotEmpty
    @Pattern(regexp = "^[а-яА-Яa]+$", message = "ввод только русскими буквами, не должен содержать латинских букв")
    private String author;
    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @Pattern(regexp = "^[0-9]{4}$", message = "длинна 4 символа, только цифры")
    private Date yearOfIssue;
    @NotEmpty
    private String publisher;
    private boolean inStock;
    @NotEmpty
    private String hasABook;
    private int id;

}
