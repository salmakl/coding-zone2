<%@ page import="com.youcode.codingzone2.models.Questins" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/12/2022
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Questions</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Question</th>
        <th>Id answer</th>

    </tr>
    <% ArrayList<Questins> QuestionsList = (ArrayList<Questins>)request.getAttribute("QuestionsList"); // on récupère la liste sur la session
        if (QuestionsList!= null){
            for (Questins question : QuestionsList) { %>
    <tr>
        <td> <%= question.getId() %></td>
        <td> <%= question.getQuestion() %></td>
        <td> <%= question.getId_answer() %></td>


    </tr>
    <% }
    }%>

</table>




</body>
</html>
