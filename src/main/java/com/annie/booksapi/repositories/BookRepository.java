package com.annie.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.annie.booksapi.models.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
