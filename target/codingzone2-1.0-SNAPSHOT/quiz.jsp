<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/24/2022
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>Take a Quiz</h1>
<h1><%= request.getAttribute("quizName") %></h1>
<span><%= request.getAttribute("quizDescription") %></span>
<% if (request.getAttribute("quizQuestions") != null){ %>
<span></span>
<% } %>
</body>
</html>
