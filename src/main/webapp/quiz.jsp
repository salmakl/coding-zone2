<%@ page import="java.util.ArrayList" %><%--
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
<% if(request.getAttribute("quizName") != null){ %>
<div id="quiz-pres">
    <h1>Take a Quiz</h1>
    <h1><%= request.getAttribute("quizName") %></h1>
    <span><%= request.getAttribute("quizDescription") %></span>
    <% if (request.getAttribute("quizQuestions") != null){ %>
    <span><%= request.getAttribute("incorrectCode") %></span>
    <% } %>
    <form action="dashboard" method="post">
        <input id="hide-pres" name="start-quiz" value="Commencer" type="submit"/>
    </form>
</div>
<% } %>

<form action="dashboard" method="post">
    <% String question = (String) request.getAttribute("quizQuestion");
        if (question != null){
    %>
    <span><%= question %></span>
    <span id="timer"><%= request.getAttribute("quizTime") %></span>
    <% ArrayList<String> opts = (ArrayList<String>) request.getAttribute("quizOpts");
        if (opts != null){
            for (String opt : opts) { %>
    <div>
        <input type="radio" name="selected-answer" value="<%= opt %>"/>
        <label><%= opt %></label>
    </div>
    <% } %>
    <input id="next" name="next-question" value="Suivant" type="submit"/>
    <input name="quit-quiz" value="Quitter" type="submit"/>
</form>
<% } %>
<% } %>
</body>
<script>
    let i = <%=request.getAttribute("quizTime")%>;
    if (i != null){
        const x = setInterval(function () {
            i--;
            document.getElementById("timer").innerHTML = i + " s";
            if (i === 0) {
                clearInterval(x);
                document.getElementById("next").click();
                console.log(document.getElementById("next"))
            }
        }, 1000);
    }
</script>
</html>
