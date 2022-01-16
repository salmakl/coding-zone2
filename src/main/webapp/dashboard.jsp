<%@ page import="com.youcode.codingzone2.models.Quizzes" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/9/2022
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>O V E R V I E W</title>
</head>
<body>
<div>
    <form action="dashboard-servlet" method="get">
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
                <form action="dashboard-servlet" method="get">
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
</body>
</html>
