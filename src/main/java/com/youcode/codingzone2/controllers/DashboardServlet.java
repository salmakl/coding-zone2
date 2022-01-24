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

<<<<<<< HEAD
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
=======
@WebServlet(name = "DashboardServlet",urlPatterns = {"/dashboard"})
>>>>>>> 81fbbecef5293423f9ee084e297fba5ab0fb1fe9
public class DashboardServlet extends HttpServlet {
    ArrayList<Quizzes> quizzes = new ArrayList<>();
    ArrayList<Users> students = new ArrayList<>();
    int quizId;

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

<<<<<<< HEAD

      if (request.getParameter("get-students") != null){
=======
        // get students
        if (request.getParameter("get-students") != null){
            quizId = Integer.parseInt(request.getParameter("get-quiz-id"));
>>>>>>> 81fbbecef5293423f9ee084e297fba5ab0fb1fe9
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
<<<<<<< HEAD
            int quizzId = Integer.parseInt(request.getParameter("quizz-id"));
            System.out.println(invitedStdId + " " + invitedStdName + " " + invitedStdEmail + " " + quizzId);
=======
>>>>>>> 81fbbecef5293423f9ee084e297fba5ab0fb1fe9

            // generate UUID
            UUID uuid = UUID.randomUUID();
            String accessCode = uuid.toString();

            // quiz url
            String url = "https://www.google.com/";

            // create the invitation
            OpenSession session = new OpenSession(accessCode, invitedStdId, quizId);
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
            System.out.println("Quizz ID is: " + quizId);
        }

        // check if access code exists
        if (request.getParameter("submit-code") != null) {
            String accessCode = request.getParameter("access-code");

            OpenSession session = new OpenSessionsImpl().findById(accessCode);

            if (session.getSessionId() == null){
                request.setAttribute("incorrectCode", "Votre code d'accès est incorrect!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("guest.jsp");
                dispatcher.forward(request, response);
            } else {
                Quizzes quizz = new QuizzesImpl().find((long) session.getQuizId());

                request.setAttribute("quizName", quizz.getName());
                request.setAttribute("quizDescription", quizz.getDescription());
                RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
                rd.forward(request, response);
            }
        }
    }
}
