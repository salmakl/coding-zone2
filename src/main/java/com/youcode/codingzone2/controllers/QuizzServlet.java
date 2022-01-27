package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.dao.DaoFactory;
import com.youcode.codingzone2.daoImpl.QuizzesImpl;
import com.youcode.codingzone2.models.Categories;
import com.youcode.codingzone2.models.Quizzes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/QuizzServlet")
public class QuizzServlet extends HttpServlet {
    //private CategoryImpl quizzCreation = new CategoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("0");
        List<Categories> CategoryList = DaoFactory.getCategoryImpl().findAll();
        System.out.println(CategoryList);
        response.setContentType("text/html");
        request.setAttribute("CategoryList", CategoryList);
        RequestDispatcher dispacher = request.getRequestDispatcher("QuizzCreation.jsp");
        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizzesImpl cd = new QuizzesImpl();
        Random rand = new Random();
        int maxNumber = 1000;
        int randomNumber = rand.nextInt(maxNumber) + 1 ;
        String quizz_name = request.getParameter("quizz_name");
        String quizz_description = request.getParameter("quizz_description");
        Integer idSelected = Integer.valueOf(request.getParameter("test"));
        System.out.println(idSelected);
        Quizzes quizzes = new Quizzes(randomNumber, quizz_name, quizz_description, idSelected);
        cd.createQuizz(quizzes);
        request.setAttribute("message", "All done !");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
