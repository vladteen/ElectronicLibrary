package com.example.libraryhw.Services;


import com.example.libraryhw.Models.Book;
import com.example.libraryhw.Repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class BookService {

    private final ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book book){
        var lastBookNumber = BookRepository.getLastNumber();
        book.setId(lastBookNumber);
        bookList.add(book);
    }
    public Book getBook(int id){
        var index = getIndex(id);
        var book = bookList.get(index);
        return book;
    }
    public ArrayList<Book> filterNameBook(String name){
        var books = new ArrayList<Book>();
        for(int i = 0; i < bookList.size(); i++){
            var currentBook = bookList.get(i);
            if(currentBook.getName().contains(name)){
                books.add(currentBook);
            }
        }
        return books;
    }

    private int getIndex(int id){
        for(int i = 0; i < bookList.size(); i++){
            var currentBook = bookList.get(i);
            if(currentBook.getId() == id){
                return i;
            }
        }
        return -1;
    }

    private int getIndex(Book book){
        return getIndex(book.getId());
    }


    public void editBook(Book book){
        var oldBookIndex = getIndex(book);
        if(oldBookIndex != -1) {
            var oldBook = bookList.get(oldBookIndex);
            oldBook.setName(book.getName());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setYearOfIssue(book.getYearOfIssue());
            oldBook.setPublisher(book.getPublisher());
            oldBook.setInStock(book.getInStock());
            oldBook.setHasABook(book.getHasABook());
        }
        else {
            bookList.add(book);
        }
    }

    public ArrayList<Book> getAllBooks(){
        return bookList;
    }

    public void deleteBook(Book book) {
        var oldBookIndex = getIndex(book);
        if(oldBookIndex != -1){
            bookList.remove(oldBookIndex);
        }
    }
}
