<%@ page import="com.youcode.codingzone2.models.Quizzes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.youcode.codingzone2.models.Users" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/9/2022
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<%--    <link rel="stylesheet" href="css/dashboard.css">--%>
    <link rel="stylesheet" href="css/main.css">

    <title>O V E R V I E W</title>
</head>
<body>
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
<div class="content">
    <form action="dashboard" method="get">
        <input name="get-quizzes" value="Quizzes" type="submit"/>
    </form>
    <table>
        <% ArrayList<Quizzes> quizzesList = (ArrayList<Quizzes>) request.getAttribute("quizzesList");
            if (quizzesList!= null){
                for (Quizzes quiz : quizzesList) { %>
        <tr>
            <td> <%= quiz.getId() %></td>
            <td> <%= quiz.getName() %></td>
            <td> <%= quiz.getDescription() %></td>
            <td>
                <form action="Student" method="get">
                    <input name="get-students" value="Invite" type="submit"/>
                </form>
            </td>
        </tr>
        <% }
        }%>
    </table>
</div>
    <div>
        <jsp:include page="popups/invite_popup.jsp"/>
    </div>
</main>

</body>
</html>
