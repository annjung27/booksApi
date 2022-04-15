package com.annie.booksapi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annie.booksapi.models.Book;
import com.annie.booksapi.services.BookService;

@Controller
public class BookController {
//	DEPENDENCY injection to use the Service here
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/")
    public String redirectMe() {
    	return "redirect:/books";
    }
    @RequestMapping("/books")
    public String index(Model model) {
    	List<Book> allBooks = bookService.allBooks();
    	model.addAttribute("allBooks", allBooks);
    	return "index.jsp";
    }
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book", book);
    	return "show.jsp";
    }
    
    
}
