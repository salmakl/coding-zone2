package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.StaffsImpl;
import com.youcode.codingzone2.models.Users;

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
        StaffsImpl staffsImpl = new StaffsImpl();

        try {
            Users user = staffsImpl.login(username,password);
            System.out.println(user);
            System.out.println("Ana hna");
            if(user != null){
                System.out.println("Ana hna2");
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                out.println("<h1>Well Done</h1>");
            }else {
                out.println("<h1>Wrong username or password</h1>");
            }
        } catch (Exception e){
            out.println("<h1>Error</h1>");
        }

    }


    public void destroy()  {

    }
}
