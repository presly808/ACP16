<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Ajax Example</title><br>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

    <script src="js/app-ajax.js" type="text/javascript"></script>

</head>
<body>

<div class="form-group">
    <button type="submit" id="showAjax" class="btn btn-default">Show Ajax</button>
</div>

<form method="post" action="register" id="myModal" hidden>
    <div class="form-registration">
        <label for="name">Name:</label>
        <input name="name" class="form-control" id="name" type="text">
    </div>
    <div class="form-group">
        <label for="age">Age:</label>
        <input name="age" class="form-control input-lg" id="age" type="text">
    </div>
    <div class="form-group">
        <label for="clan">Clan:</label>
        <input name="clan" class="form-control input-sm" id="clan" type="text">
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
        <button id="registration" type="submit" class="btn btn-default">Registration</button>
    </div>

</form>
</body>
</html>
