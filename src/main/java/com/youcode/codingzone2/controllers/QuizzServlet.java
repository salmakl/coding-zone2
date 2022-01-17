package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.dao.DaoFactory;
import com.youcode.codingzone2.daoImpl.CategoryImpl;
import com.youcode.codingzone2.daoImpl.QuizzesImpl;
import com.youcode.codingzone2.models.Categories;
import com.youcode.codingzone2.models.Quizzes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@WebServlet("/QuizzServlet")
public class QuizzServlet extends HttpServlet {
    private CategoryImpl quizzCreation = new CategoryImpl();

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
        System.out.println("am working chbghiti");
        Random rand = new Random();
        int maxNumber = 10;
        int randomNumber = rand.nextInt(maxNumber) + 1;
        String quizz_name = request.getParameter("quizz_name");
        String quizz_description = request.getParameter("quizz_description");
        Integer idSelected = Integer.valueOf(request.getParameter("test"));
        System.out.println(idSelected);
        Quizzes quizzes = new Quizzes(randomNumber, quizz_name, quizz_description, idSelected);
        cd.createQuizz(quizzes);
        quizzes.setName(quizz_name);
        quizzes.setDescription(quizz_description);
        quizzes.setId(1);
        quizzes.setId_category(2);

        request.setAttribute("message", "All done !");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
