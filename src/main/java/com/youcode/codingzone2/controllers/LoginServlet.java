package com.youcode.codingzone2.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {


    public void init()  {

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + username + "</h1>");
        out.println("<h1>" + "Heyy" + "</h1>");
        out.println("</body></html>");

    }


    public void destroy()  {

    }
}
