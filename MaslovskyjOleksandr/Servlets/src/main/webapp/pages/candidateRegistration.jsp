<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title>Candidate Registration Page</title>
</head>

<body>
<div class="container">

    <h1>Please put you info</h1>

    <form method="post" action="register">
        <div class="form-registration">
            <label for="name">Name:</label>
            <input name = "name" class="form-control" id="name" type="text">
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <input name = "age" class="form-control input-lg" id="age" type="text">
        </div>
        <div class="form-group">
            <label for="clan">Clan:</label>
            <input name = "clan" class="form-control input-sm" id="clan" type="text">
        </div>

        <div class="form-group">
            <label for="region">Region:</label>
            <input name="region" class="form-control input-sm" id="region" type="text">
        </div>

        <div class="form-group">
            <label for="hobbi">Hobbi:</label>
            <input name="interests" class="form-control input-sm" id="hobbi" type="text">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-default" >Registration</button>
        </div>

    </form>
</div>
</body>
</html>
