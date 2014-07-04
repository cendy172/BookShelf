package com.liqing.service;

import com.liqing.dao.BookRepository;
import com.liqing.domain.Book;
import com.liqing.validator.AddBookValidator;

public class AddBookService {

    private BookRepository bookRepository;
    private AddBookValidator addBookValidator;

    public AddBookService(BookRepository bookRepository, AddBookValidator addBookValidator) {
        this.bookRepository = bookRepository;
        this.addBookValidator = addBookValidator;
    }

    public void addBook(int isbn, String name, Double price, String author) {
        Book book = new Book(isbn, name, price, author);
        if (addBookValidator.validateBook(book)) {
            bookRepository.addBook(book);
        } else {
            throw new RuntimeException();
        }
    }
}
