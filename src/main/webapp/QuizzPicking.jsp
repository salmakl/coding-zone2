
<%@ page import="com.youcode.codingzone2.models.Quizzes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.youcode.codingzone2.models.Questins" %><%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 18‏/1‏/2022
  Time: 02:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/scrollbar.css">
    <script src="js/index.js"></script>
    <title>Quizz Creation</title>

</head>
<body onload="load()">

<div class="container">
    <div class="div-container-hidden">
        <div class="div-container">
            <form  action="QuizzPickingServlet" method="post">
                <div class="select-container">
                    <div class="select">
                        <% List<Quizzes> QuizzPicking = (List<Quizzes>)request.getAttribute("QuizzPicking"); %>
                        <% if(QuizzPicking != null) {%>
                        <input type="text" name="question" hidden id="question">
                        <select id="test2" name="test2">
                            <% for (Quizzes quizzes : QuizzPicking) {%>
                            <option value="<%= quizzes.getId()%>"><%= quizzes.getName()%></option>
                            <% }%>
                        </select>
                    </div>
                </div>
                <input type="submit" name="submit" class="submit-button" value="submit">
                    <% }else {  %>
                <h1>weird</h1>
                    <% } %>
        </div>
    </div>
</div>
</form>
</body>
</html>
<style>
    .select-container {
        display: flex;
        width: 100%;
        justify-content: center;
        align-items: flex-end;
        position: relative;
        top: 11em;
    }
    input.submit-button {
        position: absolute;
        top: 58%;
        left: 46.5%;
    }

</style>