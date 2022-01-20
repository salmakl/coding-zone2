package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.dao.DaoFactory;
import com.youcode.codingzone2.daoImpl.QuizzQuestionImpl;
import com.youcode.codingzone2.models.QuizzQuestions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QuizzPickingServlet")
public class QuizzPickingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List QuizzPicking = DaoFactory.getQuizzPickingImpl().findAll();
        response.setContentType("text/html");
        request.setAttribute("QuizzPicking", QuizzPicking);
        RequestDispatcher dispacher = request.getRequestDispatcher("QuizzPicking.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizzQuestionImpl cd = new QuizzQuestionImpl();
        System.out.println("am working ta ana chbghiti");
        //Integer idquestion = Integer.valueOf(request.getParameter("test1"));
        //Integer idquizz = Integer.valueOf(request.getParameter("test2"));
        //System.out.println(idquestion);
        //System.out.println(idquizz);
        QuizzQuestions quizzes = new QuizzQuestions(1001, 11);
        cd.insertQuizzQuestion(quizzes);
        request.setAttribute("message", "All done !");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
