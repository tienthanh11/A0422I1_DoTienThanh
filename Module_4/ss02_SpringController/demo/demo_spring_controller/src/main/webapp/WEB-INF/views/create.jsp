<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2022
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Student</title>
</head>
<body>
<h1>Create New Student</h1>
<form action="/create" method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Code Student:</td>
                <td><input type="text" name="codeStudent"></td>
            </tr>
            <tr>
                <td>Name Student:</td>
                <td><input type="text" name="nameStudent"></td>
            </tr>
            <tr>
                <td>Point:</td>
                <td><input type="text" name="point"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="text" name="gender"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
