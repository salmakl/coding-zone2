<%@ page import="com.youcode.codingzone2.models.Students" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/10/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Students</h1>
<div>
   <form action="StudentServlet" method="post">
       <input type="text" name="search" >
       <input type="submit" value="Search" name="find">
   </form>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>classe</th>
        <th>promotion</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <% ArrayList<Students> StudentsList = (ArrayList<Students>)request.getAttribute("stdsList");
    if (StudentsList!= null){
    for (Students student : StudentsList) { %>
    <tr>
        <td> <%= student.getId() %></td>
        <td> <%= student.getFirstname() %></td>
        <td> <%= student.getClasse() %></td>
        <td> <%= student.getPromotion() %></td>
        <td> <%= student.getEmail() %></td>
        <td>
     Send Test
        </td>
    </tr>
        <% }
        }%>

</table>




</body>
</html>
