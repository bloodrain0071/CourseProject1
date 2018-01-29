<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 4/20/17
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">

    <script type="text/javascript">

        history.pushState(null, null, 'login.jsp');
        window.addEventListener('popstate', function(event) {
            history.pushState(null, null, 'login.jsp');
        });

    </script>


</head>

<body>
<div id="login">
    <form name='form-login' action="ls" method="post">
        <span class="fontawesome-user"></span>
        <input type="text" id="user" placeholder="Username" name="username">

        <span class="fontawesome-lock"></span>
        <input type="password" id="pass" placeholder="Password" name="password">
        <c:if test="${not empty invalid}">
            <label class="msg">${invalid}</label>
        </c:if>

        <input type="submit" value="Login">

    </form>
</div>

</body>
</html>
