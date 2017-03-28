<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

  Created by IntelliJ IDEA.
  User: alex
  Date: 28.03.17
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Info</title>
</head>
<body>

<%--
<% Candidate transfered = (Candidate) request.getAttribute("candidate");%>
--%>
<c:set var="transfered" value="${candidate}"/>

<div class="container">
    <ul>
        <li>
            <div class="column">
                id : ${transfered.id}
            </div>
        </li>
        <li>
            <div class="column">
                <h1>name : ${transfered.name}</h1>
            </div>
        </li>
        <li>
            <div class="column">
                age : ${transfered.age}
            </div>
        </li>
        <li>
            <div class="column">
                clan : ${transfered.clan}
            </div>
        </li>
    </ul>
</div>
</body>
</html>