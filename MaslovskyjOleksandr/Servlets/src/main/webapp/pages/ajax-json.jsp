<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Ajax-Json Example</title><br>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>

<div style="width:1200px;">
    <div style="float: left; width: 130px"><button type="submit" id="showAjax" class="btn btn-default">Show Registration Candidate Form</button></div>
    <div style ="float: right; width: 130px"><button type="submit" id="showAllInfo" class="btn btn-default">Show Registered Candidates</button></div>
</div>

<div style="position: absolute; top: 70px; left: 50px; width: 200px; height: 200px;" id="registrationForm" hidden>
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
        <button id="register" type="submit" class="btn btn-default">Registration</button>
    </div>

</div>

<div id="candidateList">

</div>

</body>

    <script src="js/ajax-json.js" type="text/javascript"></script>

</html>
