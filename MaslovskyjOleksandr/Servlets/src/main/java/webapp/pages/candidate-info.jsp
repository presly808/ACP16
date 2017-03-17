<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="models.Candidate.java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Candidate Info</title>
</head>
<body>
  <c:set var = "candidate" value = "${candidate}"/>

  <div class="container">
    <ul>
      <li>
        <div class="column">
          name : ${candidate.name}
        </div>
      </li>

      <li>
        <div class="column">
          age : ${candidate.age}
        </div>
      </li>

      <li>
        <div class="column">
          clan : ${candidate.clan}
        </div>
      </li>

      <li>
        <div class="column">
          region : ${candidate.region}
        </div>
      </li>

      <li>
        <div class="column">
          hobbi : ${candidate.interests}
        </div>
      </li>

      <li>
        <div class="column">
          age : ${candidate.age}
        </div>
      </li>

    </ul>

  </div>
</body>

</html>