<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center>
    <h1 class="text-primary">Student List</h1>
    <a href="/create" class="btn btn-success" role="button">Create New Student</a>
    <span class="text-danger">${msg}</span>
</center>
<br><br>
<table class="table table-hover" style="text-align: center">
    <thead>
    <tr>
        <th scope="col">Code Student</th>
        <th scope="col">Name Student</th>
        <th scope="col">Point</th>
        <th scope="col">Gender</th>
        <th scope="col">Rank</th>
        <th scope="col">Detail by PathVariable</th>
        <th scope="col">Detail by RequestParam</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tmp" items="${listStudent}">
        <tr>
            <td>${tmp.codeStudent}</td>
            <td>${tmp.nameStudent}</td>
            <td><c:out value="${tmp.point}"></c:out></td>
            <td>
                <c:if test="${tmp.gender == 0}">
                    FeMale
                </c:if>
                <c:if test="${tmp.gender == 1}">
                    Male
                </c:if>
                <c:if test="${tmp.gender == 2}">
                    Other
                </c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${tmp.point > 8}">Very Good</c:when>
                    <c:when test="${tmp.point > 6.5}">Good</c:when>
                    <c:when test="${tmp.point > 5}">Not good</c:when>
                    <c:when test="${tmp.point > 3.5}">Bad</c:when>
                    <c:when test="${tmp.point <= 3.5}">Very Bad</c:when>
                </c:choose>
            </td>
            <td><a href="/detail/${tmp.codeStudent}">Detail</a></td>
            <td><a href="/detail?id=${tmp.codeStudent}">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
