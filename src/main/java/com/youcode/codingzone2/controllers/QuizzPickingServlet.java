package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.dao.DaoFactory;
import com.youcode.codingzone2.daoImpl.QuizzQuestionImpl;
import com.youcode.codingzone2.models.Questins;
import com.youcode.codingzone2.models.QuizzQuestions;
import com.youcode.codingzone2.models.Quizzes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QuizzPickingServlet")
public class QuizzPickingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quizzes>  QuizzPicking = DaoFactory.getQuizzPickingImpl().findAll();
        response.setContentType("text/html");
        request.setAttribute("QuizzPicking", QuizzPicking);
        RequestDispatcher dispacher = request.getRequestDispatcher("QuizzPicking.jsp");
        dispacher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizzQuestionImpl cd = new QuizzQuestionImpl();
        Integer idquizz = Integer.valueOf(request.getParameter("test2"));
        Integer idquestion = Integer.valueOf(request.getParameter("question"));
        QuizzQuestions quizzes = new QuizzQuestions(idquizz, idquestion);
        cd.insertQuizzQuestion(quizzes);
        request.setAttribute("message", "All done !");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
