package com.liqing.dao;

import com.liqing.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookRepository {

    private JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book){
        jdbcTemplate.execute("insert into book values(" + book.getIsbn() + ",\"" + book.getName() + "\"," + book.getPrice() + ",\"" + book.getAuthor() + "\")");
    }

}
