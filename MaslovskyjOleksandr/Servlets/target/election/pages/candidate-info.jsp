<%@ page import="models.Candidate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <title>Candidate Info</title>
</head>
<body>
<c:set var="can" value="${candidate}"/>

<form method="post" action="register">
    <div class="form-group">
        <button type="button" class="btn btn-default">Show Candidates Info</button>
    </div>

    <div class="table-responsive" title="Candidates">
        <table class="table">
            <div class="column">
                name : ${candidate.name}
            </div>
            <div class="column">
                age : ${candidate.age}
            </div>
            <div class="column">
                clan : ${candidate.clan}
            </div>
            <div class="column">
                region : ${candidate.region}
            </div>
            <div class="column">
                hobbi : ${candidate.interest}
            </div>
            <div class="column">
                age : ${candidate.age}
            </div>
        </table>
    </div>

</form>

</body>

</html>