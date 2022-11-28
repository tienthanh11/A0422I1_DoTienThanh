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
        </table>
    </fieldset>
</form>
</body>
</html>
