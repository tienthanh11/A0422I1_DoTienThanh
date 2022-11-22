<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<center>
    <h2>Vietnamese Dictionary</h2>
    <form method="post">
        <input type="text" name="word" placeholder="Enter English Word: ">
        <input type="submit" id="submit" value="Search">
    </form>
    <div>
        <c:out value="${result}"></c:out>
    </div>
</center>
</body>
</html>
