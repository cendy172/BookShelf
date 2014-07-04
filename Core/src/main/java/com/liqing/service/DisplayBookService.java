package com.liqing.service;

import com.liqing.dao.BookRepository;
import com.liqing.domain.Book;

import java.util.List;

public class DisplayBookService {

    private BookRepository bookRepository;

    public DisplayBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
