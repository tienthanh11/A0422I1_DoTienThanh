<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>List Student</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
