package com.liqing.service;

import com.liqing.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddBookServiceTest {

    private DisplayBookService displayBookService;

    @Before
    public void setUp() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        displayBookService = (DisplayBookService) classPathXmlApplicationContext.getBean("displayBookService");
    }

    @Test
    public void shouldAddBook() {
        List<Book> allBooks = displayBookService.getAllBooks();

        assertThat(allBooks.size(), is(3));
    }
}
