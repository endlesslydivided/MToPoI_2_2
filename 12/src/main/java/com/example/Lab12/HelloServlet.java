package com.example.Lab12;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setAttribute("message", "<script>alert('Hello gold')</script");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}