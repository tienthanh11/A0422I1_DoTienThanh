<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 11/18/2022
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>Update student</h1>
    <form action="/student/update" method="post">
        <table border="1">
            <tr>
                <td>ID</td>
                <td><input type="text" value="${student.id}" name="id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" value="${student.name}" name="name"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" value="${student.age}" name="age"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" value="${student.address}" name="address"></td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
