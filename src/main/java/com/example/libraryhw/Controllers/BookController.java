package com.example.libraryhw.Controllers;

import com.example.libraryhw.Models.Book;
import com.example.libraryhw.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("newBook", new Book());
        return "registration";
    }

    @RequestMapping("/addNewBook")
    public String addNewBook(Book bookToAdd)
    {
        bookService.addBook(bookToAdd);
        return "redirect:/allBooks";
    }

    @RequestMapping("/allBooks")
    public String showAllBooks(Model model)
    {
        var allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "allBooks";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable(value = "id") int id, Model model){
        var book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(Book bookToEdit)
    {
        bookService.editBook(bookToEdit);
        return "redirect:/allBooks";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.POST)
    private String deleteBook(@PathVariable(value = "id") int id){
        var book = bookService.getBook(id);
        bookService.deleteBook(book);
        return "redirect:/allBooks";
    }
}