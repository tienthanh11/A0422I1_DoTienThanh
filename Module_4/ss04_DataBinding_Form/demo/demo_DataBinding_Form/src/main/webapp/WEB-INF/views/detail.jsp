<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Student</title>
</head>
<body>
<h1>Information Detail Student</h1>
<form action="/detail" method="get">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Code Student:</td>
                <td><input type="text" name="codeStudent" value="${student.codeStudent}"></td>
            </tr>
            <tr>
                <td>Name Student:</td>
                <td><input type="text" name="nameStudent" value="${student.nameStudent}"></td>
            </tr>
            <tr>
                <td>Point:</td>
                <td><input type="text" name="point" value="${student.point}"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="text" name="gender" value="${student.gender}"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
