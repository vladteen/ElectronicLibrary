package com.example.libraryhw.Controllers;

import com.example.libraryhw.Models.Book;
import com.example.libraryhw.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

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
    public String addNewBook(@Valid @ModelAttribute("newBook") Book bookToAdd, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        bookService.addBook(bookToAdd);
        return "redirect:/allBooks";
    }

    @RequestMapping("/allBooks")
    public String showAllBooks(String pageNumber, String name, Model model)
    {
        var recordCountOnPage = 2;
        if (pageNumber == null || pageNumber == "")
            pageNumber = "1";
        var pageNumberInt =  Integer.parseInt(pageNumber);
        if (pageNumberInt < 1)
            pageNumberInt = 1;

        if(name == null || name == "") {
            var allBooks = bookService.getAllBooks();
            var booksInPage = bookService.getBooksInPage(pageNumberInt, recordCountOnPage, allBooks);
            model.addAttribute("books", booksInPage);
            var countPages = bookService.getPageNumber(recordCountOnPage, allBooks);
            model.addAttribute("countPages", countPages);
        }
        else{
            var filteredBooks = bookService.filterNameBook(name);
            var booksInPage = bookService.getBooksInPage(pageNumberInt, recordCountOnPage, filteredBooks);
            model.addAttribute("books", booksInPage);
            model.addAttribute("nameValue", name);
            var countPages = bookService.getPageNumber(recordCountOnPage, filteredBooks);
            model.addAttribute("countPages", countPages);
        }
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
