<%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 12‏/1‏/2022
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.youcode.codingzone2.models.Categories" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quizz Creation</title>
</head>
<body>
<form action="QuizzServlet" method="post">
<h1>Quizz Creation</h1>
<% List<Categories> CategoryList = (List<Categories>)request.getAttribute("CategoryList"); // on récupère la liste sur la sessio
%>

        <%
    if (CategoryList!=null){
        %>
    <label>Quizz Name</label>
    <input type="text" name="quizz_name" id="quizz_name">
    <label>Quizz Description</label>
    <input type="text" name="quizz_description" id="quizz_description">
    <label>Categories</label>
    <select>
        <%
        for (Categories category : CategoryList) { %>
    <option> <%= category.getId() %> - <%= category.getCategory() %></option>
<% }
        %>
    </select>
    <br/>
    <input type="submit" id="submit"  name="submit" value="next">
    <%
} else {
    %>
   <h1>Error 404 wrong page u shoudln't be here</h1>
<%
    }
%>

</form>
</body>
</html>
