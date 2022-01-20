package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.dao.DaoFactory;
import com.youcode.codingzone2.models.Categories;
import com.youcode.codingzone2.models.Questins;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QuizzQuestionServlet")
public class QuizzQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("quizz question");
        List<Questins> QuestionList = DaoFactory.getQuizzQuestionImpl().findAll();
        System.out.println(QuestionList);
        response.setContentType("text/html");
        request.setAttribute("QuestionList", QuestionList);
        RequestDispatcher dispacher = request.getRequestDispatcher("QuizzQuestion.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
