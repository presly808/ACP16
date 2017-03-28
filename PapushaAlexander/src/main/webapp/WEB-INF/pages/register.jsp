<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.03.17
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <div class="container">
        <h1>Input register candidate</h1>

        <form method="post" action="register">
            <ul>
                <li>Input name:
                    <input name="name" type="text">
                </li>
                <li>Input age:
                    <input name="age" type="text">
                </li>
                <li>Submit:
                    <input type="submit">
                </li>
            </ul>
        </form>

    </div>

</body>
</html>
