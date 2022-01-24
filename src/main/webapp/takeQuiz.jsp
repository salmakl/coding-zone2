<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/24/2022
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Take A Quiz | Coding Zone</title>
</head>
<body>
<form action="dashboard" method="post">
    <label>Insérer votre code ici</label>
    <input name="access-code" value="" type="text"/>
    <input name="submit-code" type="submit" value="Send"/>
    <% if (request.getAttribute("incorrectCode") != null){ %>
    <span><%= request.getAttribute("incorrectCode") %></span>
    <% } %>
</form>
</body>
</html>
