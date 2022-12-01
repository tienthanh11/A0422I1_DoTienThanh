<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create New Student</title>
</head>
<body>
<h1>Create New Student</h1>
<form:form action="/create" method="post" modelAttribute="student">
    <table>
        <tr>
            <td>Code Student:</td>
            <td><form:input type="text" path="codeStudent"/></td>
        </tr>
        <tr>
            <td>Name Student:</td>
            <td><form:input type="text" path="nameStudent"/></td>
        </tr>
        <tr>
            <td>Point:</td>
            <td><form:input type="text" path="point"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                    <%--                    <form:select path="gender">--%>
                    <%--                        <form:options items="${genderList}"></form:options>--%>
                    <%--                    </form:select>--%>

                    <%--                    <form:checkboxes path="gender" items="${genderList}"></form:checkboxes>--%>

                <form:radiobuttons path="gender" items="${genderList}"></form:radiobuttons>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Create Student</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
