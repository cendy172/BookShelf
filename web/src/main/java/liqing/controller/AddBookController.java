package liqing.controller;

import com.liqing.domain.Book;
import com.liqing.service.AddBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookController extends HttpServlet {
    private AddBookService addBookService;

    @Override
    public void init() throws ServletException {
        super.init();
        addBookService = (AddBookService) getServletConfig().getServletContext().getAttribute("addBookService");
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Book book = new Book();
        book.setIsbn(Integer.valueOf(httpRequest.getParameter("isbn")));
        book.setName(httpRequest.getParameter("name"));
        book.setPrice(Double.valueOf(httpRequest.getParameter("price")));
        book.setAuthor(httpRequest.getParameter("author"));

        addBookService.addBook(book);
        httpServletResponse.sendRedirect("display");
    }

}
