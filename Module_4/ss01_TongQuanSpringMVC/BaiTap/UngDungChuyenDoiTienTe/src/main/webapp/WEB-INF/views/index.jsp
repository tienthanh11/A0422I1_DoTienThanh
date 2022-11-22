<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currency Convert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center>
    <h1 class="btn text-primary">USD To VND</h1>
    <form class="from-control" method="post">
        <h5>USD</h5>
        <div>
            <input type="number" name="usd">
        </div>
        <br>
        <div>
            <button type="submit" class="btn btn-warning" name="convert">Convert</button>
            <span><c:out value="${vnd}"></c:out></span>
        </div>
    </form>
</center>
</body>
</html>
