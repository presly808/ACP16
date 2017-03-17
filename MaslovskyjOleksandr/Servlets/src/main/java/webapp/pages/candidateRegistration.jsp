<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
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
