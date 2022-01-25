package com.youcode.codingzone2.controllers;

import com.youcode.codingzone2.daoImpl.*;
import com.youcode.codingzone2.helpers.EmailSender;
import com.youcode.codingzone2.models.*;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "DashboardServlet",urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    ArrayList<Quizzes> quizzes = new ArrayList<>();
    ArrayList<Users> students = new ArrayList<>();
    ArrayList<SingleQuizz> quizQuestions;
    OpenSession session;
    int quizId;
    String currentQuestion;
    String answer;
    int timeLimit;
    ArrayList<String> shuffledOpts = new ArrayList<>();
    int questionIndex;
    int isCorrect;
    float score;

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


        // get students
        if (request.getParameter("get-students") != null){
            quizId = Integer.parseInt(request.getParameter("get-quiz-id"));
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

            session = new OpenSessionsImpl().findById(accessCode);

            if (session.getSessionId() == null){
                request.setAttribute("incorrectCode", "Votre code d'accès est incorrect!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("takeQuiz.jsp");
                dispatcher.forward(request, response);
            } else {
                Quizzes quizz = new QuizzesImpl().find((long)  session.getQuizId());

                request.setAttribute("quizName", quizz.getName());
                request.setAttribute("quizDescription", quizz.getDescription());
                RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
                rd.forward(request, response);
            }
        }

        // take a quiz
        if (request.getParameter("start-quiz") != null){

            // get quz questions
            quizQuestions = new SingleQuizzImpl().getAll(session.getQuizId());

            // set question
            questionIndex = 0;
            setQuestion();

            // initialize score
            isCorrect = 0;

            request.setAttribute("quizQuestion", currentQuestion);
            request.setAttribute("quizTime", timeLimit);
            request.setAttribute("quizOpts", shuffledOpts);
            RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
            rd.forward(request, response);

        }

        // take a quiz
        if (request.getParameter("next-question") != null){

            String selected = request.getParameter("selected-answer");

            // increase score if result is correct
            if (answer.equals(selected)){
                isCorrect++;
            }

            // check if quiz is finished
            if (questionIndex == (quizQuestions.size()-1)){
                // cal score
                score = (isCorrect * 100) / (quizQuestions.size());

                // get timestamps
                Timestamp date = new Timestamp(new Date().getTime());

                // delete invite
                new OpenSessionsImpl().delete(session);

                // save score
                Archive archive = new Archive(session.getQuizId(), session.getStudentId(), score, date);
                new ArchiveImpl().create(archive);

            } else {
                // change question index
                questionIndex++;

                // clear opts
                shuffledOpts.clear();

                // update question details
                setQuestion();

                request.setAttribute("quizQuestion", currentQuestion);
                request.setAttribute("quizTime", timeLimit);
                request.setAttribute("quizOpts", shuffledOpts);
                RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
                rd.forward(request, response);
            }
        }

        // quit quiz
        if(request.getParameter("quit-quiz") != null){
            // get timestamps
            Timestamp date = new Timestamp(new Date().getTime());

            // delete invite
            new OpenSessionsImpl().delete(session);

            // save score
            Archive archive = new Archive(session.getQuizId(), session.getStudentId(), score, date);
            new ArchiveImpl().create(archive);

            response.sendRedirect(request.getContextPath() + "/takeQuiz.jsp");
        }
    }

    // set question
    public void setQuestion(){

        // get question
        currentQuestion = quizQuestions.get(questionIndex).getQuestion();

        // get time limit
        timeLimit = quizQuestions.get(questionIndex).getTimeLimit();

        // get answer
        answer = quizQuestions.get(questionIndex).getAnswer();

        // shuffle options
        getOpt(quizQuestions.get(questionIndex).getOptions());
        shuffledOpts.add(answer);
        Collections.shuffle(shuffledOpts);
    }

    // remove options from array
    public void getOpt(String opts){
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(quizQuestions.get(questionIndex).getOptions());
        while (m.find()) {
            shuffledOpts.add(m.group(1));
        }
    }
}
