package com.library.service.impl;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.showListBook();
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Book findAllByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Override
    public void borrow(Integer id) {
        bookRepository.borrowBook(id);
    }

    @Override
    public void returnBook(Integer id) {
        bookRepository.returnBook(id);
    }

    @Override
    public Integer returnBookCheckId(Integer id) {
        return bookRepository.returnBookCheckId(id);
    }

}
