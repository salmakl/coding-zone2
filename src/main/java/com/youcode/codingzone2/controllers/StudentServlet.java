package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.StudentsImpl;
import com.youcode.codingzone2.daoImpl.UsersImpl;
import com.youcode.codingzone2.models.Students;
import com.youcode.codingzone2.models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", urlPatterns = {"/Student"})
public class StudentServlet extends HttpServlet {


    private StudentsImpl studentsImpl=new StudentsImpl();
    private ArrayList<Students> StudentsList;
    @Override
    public void init() throws ServletException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("get-students") != null){
            ArrayList<Students> students = new StudentsImpl().getAll();
            for (int i=0;i<students.size();i++){
            System.out.println(students.get(i).getFirstname());
            }
            request.setAttribute("stdsList", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);

        }


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
