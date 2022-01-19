<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/8/2022
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link rel="stylesheet" href="css/login.css">
    <title>L O G I N</title>
</head>
<body>

    <div class="form">
        <h1>Login Member</h1>

        <form action="login-servlet" method="POST">

            <div class="formInput">
                <input type="text" placeholder="Email" name="username" >
            </div>
            <div class="formInput" >


                <input type="password"placeholder="Password" name="password" >
            </div>
            <div class="formInput">
                <input type="submit" class="btn btn-primary" value="Log In">
            </div>
        </form>
    </div>

</body>
</html>
