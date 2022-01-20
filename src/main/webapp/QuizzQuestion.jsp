<%@ page import="com.youcode.codingzone2.models.Questins" %>
<%@ page import="java.util.List" %>
<%@ page import="com.youcode.codingzone2.models.Questins" %>
<%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 17‏/1‏/2022
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quizz Question page</h1>
<form method="post" action="QuizzQuestionServlet">
    <% List<Questins> QuestionList = (List<Questins>)request.getAttribute("QuestionList"); %>
    <% if(QuestionList != null) {%>
        <select id="test1" name="test1">
        <% for (Questins question : QuestionList) {%>
        <option value="<%= question.getId()%>"><%= question.getQuestion()%></option>
    <% }%>
        </select>
    <a href="QuizzPickingServlet" style="color:#000">next</a>

    <% }else {  %>
    <h1>weird</h1>
    <% } %>
</form>
</body>
</html>
