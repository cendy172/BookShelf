package com.liqing.dao;

import com.liqing.domain.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookRepository {

    private JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book) {
        jdbcTemplate.execute("insert into book values(" + book.getIsbn() + ",\"" + book.getName() + "\"," + book.getPrice() + ",\"" + book.getAuthor() + "\")");
    }

    public List<Book> getAllBooks() {

        List<Book> books = jdbcTemplate.query("select * from book", new BeanPropertyRowMapper(Book.class));

        return books;

    }
}
