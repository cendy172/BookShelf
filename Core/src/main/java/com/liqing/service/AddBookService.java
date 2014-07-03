package com.liqing.service;

import com.liqing.domain.Book;
import com.liqing.validator.AddBookValidator;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddBookService {

    private JdbcTemplate jdbcTemplate;
    private AddBookValidator addBookValidator;

    public AddBookService(JdbcTemplate jdbcTemplate, AddBookValidator addBookValidator) {
        this.jdbcTemplate = jdbcTemplate;
        this.addBookValidator = addBookValidator;
    }

    public void addBook(Book book) {
        if(addBookValidator.validateBook(book)){
            jdbcTemplate.execute("insert into book values(" + book.getIsbn() + ",\"" + book.getName() + "\"," + book.getPrice() + ",\"" + book.getAuthor() + "\")");
        }else{
            throw new RuntimeException();
        }

    }

}
