<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>Candidate Registration Page</title>
  </head>

  <body>
        <div class = "container">

          <h1>Please put you info</h1>

          <form method="post" action="register">
            <ul>
                <li>Input name:
                  <input name="name" type="text">
                </li>

                <li>Input age:
                  <input age="age" type="text">
                </li>

                <li>Input clan:
                  <input name="clan" type="text">
                </li>

                <li>Choose your Region:
                  <input name="region"  list="">
                </li>

                <li>Input your hobbi:
                  <input name="interests" type="text">
                </li>

                <li>registration
                  <button name="registration" type="submit">
                </li>

            </ul>

          </form>

  </body>
</html>
