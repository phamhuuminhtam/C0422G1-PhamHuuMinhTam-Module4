package com.library.service;

import com.library.model.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findByName(String name);
    Book findAllByName(String name);
    void borrow(Integer id);
    void returnBook(Integer id);
    Integer returnBookCheckId(Integer id);
}
