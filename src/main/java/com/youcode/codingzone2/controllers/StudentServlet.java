package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.StudentsImpl;
import com.youcode.codingzone2.models.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {


    private StudentsImpl studentsImpl=new StudentsImpl();
    private ArrayList<Students> StudentsList;
    @Override
    public void init() throws ServletException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet");
        StudentsList=studentsImpl.getAll();
        System.out.println(StudentsList.get(0).getPromotion());
        System.out.println(StudentsList.get(0).getClasse());
        System.out.println(StudentsList.get(0).getFirstname());
        request.setAttribute("StudentsList", StudentsList);
        RequestDispatcher dispacher =request.getRequestDispatcher("students.jsp");
        dispacher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doPost");
        String search=request.getParameter("search");
        StudentsImpl studentsImpl=new StudentsImpl();
        StudentsList=studentsImpl.filter(search);
        System.out.println("am here");
        System.out.println(StudentsList.get(0).getPromotion());
        PrintWriter out = response.getWriter();
        out.println("<h1>Well Done</h1>");
    }
}
