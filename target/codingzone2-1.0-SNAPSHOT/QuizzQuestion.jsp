<%@ page import="com.youcode.codingzone2.models.Questins" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 17‏/1‏/2022
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/scrollbar.css">
    <script src="js/index.js"></script>
    <title>Quizz Creation</title>
</head>
<body>
<div class="container">
    <div class="div-container-hidden">
        <div class="div-container">
            <h1 class="h1-title">Creating a Quizz</h1>
            <p class="p-paragrah">Select a question from the select input please </p>
            <label class="label-select">SELECT QUESTION</label>
            <div class="select-container">
                <div class="select">
                    <form action="QuizzQuestionServlet" method="post">
                        <% List<Questins> QuestionList = (List<Questins>)request.getAttribute("QuestionList"); %>
                        <% if(QuestionList != null) {%>
                        <select name="test" id="select">
                                <% for (Questins question : QuestionList) {%>
                                <option id="option-value" value="<%= question.getId()%>"><%= question.getQuestion()%></option>
                                <% }%>
                            </select>
                    </form>
                </div>
            </div>
            <button class="submit-button" onclick="next()" name="submit"><a href="QuizzPickingServlet">Next</a></button>
            <% }else {  %>
            <h1>weird</h1>
            <% } %>
            <div class="styling-div"></div>
        </div>
    </div>
</div>
</body>
</html>