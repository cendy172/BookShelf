package com.liqing.service;

import com.liqing.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddBookService {

    private JdbcTemplate jdbcTemplate;

    public AddBookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book) {
        jdbcTemplate.execute("insert into book values(" + book.getIsbn() + ",\"" + book.getName() + "\"," + book.getPrice() + ",\"" + book.getAuthor() + "\")");
    }

}
