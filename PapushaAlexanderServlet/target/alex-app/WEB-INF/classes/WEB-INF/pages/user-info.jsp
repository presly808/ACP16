<%@ page import="ua.artcode.week8.model.User" %><%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 25.03.17
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

    <% User transfered = (User) request.getAttribute("user");%>

    <div class="container">
        <ul>
            <li>
                <div class="column">
                    <h1>name : <%= transfered.getName()%></h1>
                </div>
            </li>
            <li>
                <div class="column">
                    id : <%= transfered.getId()%>
                </div>
            </li>
            <li>
                <div class="column">
                    salary : <%= transfered.getSalary()%>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>
