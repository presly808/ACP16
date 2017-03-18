<%@ page import="models.Candidate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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