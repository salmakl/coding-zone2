package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.QuestionImpl;
import com.youcode.codingzone2.daoImpl.StudentsImpl;
import com.youcode.codingzone2.models.Questins;
import com.youcode.codingzone2.models.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuestionServlet", value = "/QuestionServlet")
public class QuestionServlet extends HttpServlet {

    private QuestionImpl questionsImpl=new QuestionImpl();
    private ArrayList<Questins> QuestionsList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionsList=questionsImpl.getAll();
        request.setAttribute("QuestionsList",QuestionsList);;
        RequestDispatcher dispacher =request.getRequestDispatcher("questions.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
