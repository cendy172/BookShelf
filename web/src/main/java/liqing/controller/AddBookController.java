package liqing.controller;

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
        Integer isbn = Integer.valueOf(httpRequest.getParameter("isbn"));
        String name = httpRequest.getParameter("name");
        Double price = Double.valueOf(httpRequest.getParameter("price"));
        String author = httpRequest.getParameter("author");

        addBookService.addBook(isbn, name, price, author);
        httpServletResponse.sendRedirect("display");
    }

}
