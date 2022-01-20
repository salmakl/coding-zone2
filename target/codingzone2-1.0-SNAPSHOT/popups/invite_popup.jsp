<%@ page import="com.youcode.codingzone2.models.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.youcode.codingzone2.models.Students" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/12/2022
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>Inviter des apprenants</span>
<input type="search"/>
    <% ArrayList<Users> studentsList = (ArrayList<Users>) request.getAttribute("stdsList");
        if (studentsList!= null){
            for (Users student : studentsList) { %>

        <div>
            <form action="dashboard-servlet" method="post">
                <input name="quizz-id" value="1001" type="hidden" hidden="hidden"/>
                <input name="invited-std-id" value="<%= student.getId() %>" type="text" hidden="hidden"/>
                <input name="invited-std-name" value="<%= student.getFirstname() + " " + student.getLastname() %>" type="text" readonly/>
                <input name="invited-std-email" value="<%= student.getEmail() %>" type="text" readonly/>
                <input name="send-invite" value="Invite" type="submit"/>
            </form>
        </div>
    <% }
    }%>
