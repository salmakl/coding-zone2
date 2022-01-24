<%@ page import="com.youcode.codingzone2.models.Quizzes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>




<!doctype html>

<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="css/main.css" rel="stylesheet">
    <title>W</title>

</head>

<body>

<a href="hello-servlet">Hello Servlet</a>
<a href="dashboard.jsp">Dashboard</a>
<a href="QuestionServlet">Question Servlet</a>
<a href="Login.jsp">Login</a>
<a href="QuizzServlet">Creation of the Quizz</a>
<a href="Student">Students</a>

<<<<<<< HEAD

<nav class='container'>
    <div class="logo">
        <a href="#"><img src="img/logo.png" alt="" /></a>
    </div>

<%--    <div class='search'>--%>
<%--        <input type="text">--%>
<%--        <img src="img/icons/search.svg" alt="" />--%>
<%--    </div>--%>


        <div>
            <p>Welcome, Admin </p>
            <div class="profil">
                <img src="img/icons/user.svg" alt="">
            </div>
        </div>


</nav>


<aside>

    <div class="sidebar">
        <a href="#">
        <div class="menu active">
            <img src="img/icons/dashboard.svg">
            <p> Dashboard</p>
        </div>
         </a>
        <a href="quizz">
        <div class="menu">
            <img src="img/icons/task.svg">
            <p> Quizzes </p>
        </div>
        </a>
        <a href="Student">
        <div class="menu">

                <img src="img/icons/users.svg">
                <p> Students </p>

        </div>
        </a>
        <a href="Question">
        <div class="menu">
            <img src="img/icons/archive.svg">
            <p> Archive </p>
        </div>
        </a>
    </div>

    <div class="sidebar">
    <%--    <div class="menu">
            <img src="img/icons/user.svg">
            <p> profile</p>
        </div>--%>
        <form method="POST" action="logout">

            <div class="menu">
                <button type="submit"><img src="img/icons/logout.svg" class="icon" ></button>
                <p>Log out</p>
            </div>
        </form>

    </div>


</aside>

<main>
    <section class="row">
        <div class="column card">
            <h3>Quizz title</h3>
            <p>Quizz description</p>
            <img src="img/icons/task.svg">
        </div>

        <div class="column card">
            <h3>Quizz title</h3>
            <p>Quizz description</p>
            <img src="img/icons/task.svg">
        </div>


        <div class="column card">
            <h3>Quizz title</h3>
            <p>Quizz description</p>
            <img src="img/icons/task.svg">
        </div>

        <div class="column card">
            <h3>Quizz title</h3>
            <p>Quizz description</p>
            <img src="img/icons/task.svg">
        </div>


    </section>
    <section>
        <table>
            <% ArrayList<Quizzes> quizzesList = (ArrayList<Quizzes>) request.getAttribute("quizzesList");
                if (quizzesList!= null){
                    for (Quizzes quiz : quizzesList) { %>
            <thead>
            <tr>
            <th>Quizz title</th>
            <th>Quizz description</th>
            <th>Quizz date</th>
            <th>Quizz status</th>

            </thead>
            <tbody>
            <tr>
                <td> <%= quiz.getId() %></td>
                <td> <%= quiz.getName() %></td>
                <td> <%= quiz.getDescription() %></td>
                <td>
                    <form action="dashboard" method="get">
                        <input name="get-students" value="Invite" type="submit"/>
                    </form>
                </td>
            </tr>

            </tbody>
            <% }
            }%>
        </table>
    </section>

</main>
=======
<a href="hello-servlet">Hello Servlet</a>
<a href="Login.jsp">Login</a>
<a href="QuizzServlet">Creation of the Quizz</a>
<a href="StudentServlet">Hello Servlet</a>
<a href="takeQuiz.jsp">Take A Quiz</a>
>>>>>>> 81fbbecef5293423f9ee084e297fba5ab0fb1fe9

</body>
</html>