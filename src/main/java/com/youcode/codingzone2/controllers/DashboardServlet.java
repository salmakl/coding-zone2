package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.OpenSessionsImpl;
import com.youcode.codingzone2.daoImpl.QuizzesImpl;
import com.youcode.codingzone2.daoImpl.UsersImpl;
import com.youcode.codingzone2.helpers.EmailSender;
import com.youcode.codingzone2.models.OpenSession;
import com.youcode.codingzone2.models.Quizzes;
import com.youcode.codingzone2.models.Users;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    ArrayList<Quizzes> quizzes = new ArrayList<>();
    ArrayList<Users> students = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get quizzes

        System.out.println("hello");

        quizzes = new QuizzesImpl().getAll();
        request.setAttribute("quizzesList", quizzes);
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("dashboard.jsp");
        dispatcher1.forward(request, response);

   /*     if (request.getParameter("get-quizzes") != null){

            System.out.println("hereee");
            quizzes = new QuizzesImpl().getAll();
            System.out.println(quizzes.get(0).getId());
            request.setAttribute("quizzesList", quizzes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
        }*/


      if (request.getParameter("get-students") != null){
            students = new UsersImpl().getAll();
            request.setAttribute("stdsList", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("get-students") != null){
            students = new UsersImpl().getAll();
            System.out.println(students.get(0).getFirstname());
            request.setAttribute("stdsList", students);
            //System.out.println("wwww");
            // response.sendRedirect("students.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
            dispatcher.forward(request, response);

        }

        // send invite to student
        if (request.getParameter("send-invite") != null) {

            // retrieve student details from jsp
            int invitedStdId = Integer.parseInt(request.getParameter("invited-std-id"));
            String invitedStdName = request.getParameter("invited-std-name");
            String invitedStdEmail = request.getParameter("invited-std-email");
            int quizzId = Integer.parseInt(request.getParameter("quizz-id"));
            System.out.println(invitedStdId + " " + invitedStdName + " " + invitedStdEmail + " " + quizzId);

            // generate UUID
            UUID uuid = UUID.randomUUID();
            String accessCode = uuid.toString();

            // quiz url
            String url = "https://www.google.com/";

            // create the invitation
            OpenSession session = new OpenSession(accessCode, invitedStdId, quizzId);
            new OpenSessionsImpl().create(session);
            System.out.println("hello1");
            // send email to the student
            try {
                System.out.println("hello2");
                EmailSender.sendMail(invitedStdEmail, accessCode, url);
                System.out.println("hello3");
                System.out.println("Email sent to " + invitedStdName + " at " + invitedStdEmail);

            } catch (MessagingException e) {
                e.printStackTrace();
                System.err.println("Error in sending email.");
            }

            System.out.println("Invited student ID is: " + invitedStdId);
            System.out.println("Invited student Name is: " + invitedStdName);
            System.out.println("Invited student email is: " + invitedStdEmail);
            System.out.println("Invited student UUID is: " + accessCode);
            System.out.println("Quizz ID is: " + quizzId);
        }
    }
}
