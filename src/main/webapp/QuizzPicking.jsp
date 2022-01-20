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
    <title>Title</title>
</head>
<body>
<form method="post" action="QuizzPickingServlet">
    <% List<Quizzes> QuizzPicking = (List<Quizzes>)request.getAttribute("QuizzPicking"); %>
    <% if(QuizzPicking != null) {%>
    <select id="test2" name="test2">
        <% for (Quizzes quizzes : QuizzPicking) {%>
        <option value="<%= quizzes.getId()%>"><%= quizzes.getName()%></option>
        <% }%>
    </select>
    <input type="submit" name="submit">
    <% }else {  %>
    <h1>weird</h1>
    <% } %>
</form>
</body>
</html>
