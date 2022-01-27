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

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/scrollbar.css">
</head>
<body>

<div class="container">
    <div class="div-container-hidden">
        <div class="div-container">
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
                <select name="test">
                    <%
                        for (Categories category : CategoryList) { %>
                    <option value="<%= category.getId() %>"><%=category.getCategory()%></option>
                    <% }
                    %>
                </select>
                <br/>
                <button class="submit-button" name="submit">submit</button>
                <%
                } else {
                %>
                <h1>Error 404 wrong page u shoudln't be here</h1>
                <%
                    }
                %>
                <div class="styling-div"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<style>
    select {
        width: 25em;
        appearance: none;
        outline: 0;
        border: 0;
        box-shadow: none;
        max-height: 13em;
        flex: 1;
        padding: 0 1em;
        color: #fff;
        font-weight: bold;
        background-color: #14279B;
        background-image: none;
        cursor: pointer;
        height: 2em;
        margin-top: 2em;
    }
    h1 {
        position: relative;
        left: 7em;
    }
    label {
        font-weight: bold;
    }
    button {
        position: relative;
        top: 1.3em;
        left: 18em;
    }
    .div-container {
        background-color: #fff;
        box-shadow: rgb(0 0 0 / 25%) 0px 54px 55px, rgb(0 0 0 / 12%) 0px -12px 30px, rgb(0 0 0 / 12%) 0px 4px 6px, rgb(0 0 0 / 17%) 0px 12px 13px, rgb(0 0 0 / 9%) 0px -3px 5px;
        width: 40em;
        height: 16em;
        display: grid;
        grid-template-columns: repeat(1, 1fr);
        gap: 5px;
    }
</style>