package com.annie.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.annie.booksapi.models.Book;
import com.annie.booksapi.repositories.BookRepository;

@Service
public class BookService {
//	 adding the book repository as a dependency
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
 // READ ALL
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // CREATE Book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // READ ONE by ID
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // UPDATE ONE
    public Book updateBook(Book b) {    	
    	return bookRepository.save(b);   
    }
    // DELETE ONE
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

