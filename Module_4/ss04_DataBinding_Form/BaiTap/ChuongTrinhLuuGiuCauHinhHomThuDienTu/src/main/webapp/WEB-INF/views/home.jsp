<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" method="post" modelAttribute="Email">
    <table>
        <tr>
            <th><form:label path="languages">Languages: </form:label></th>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="page">Page Size: </form:label></th>
            <td>
                <span>Show </span>
                <form:select path="page">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <th><form:label path="filter">Spams filter: </form:label></th>
            <td><form:checkbox path="filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <th><form:label path="signature">Signature: </form:label></th>
            <td><form:textarea path="signature" cols="20" rows="5"></form:textarea></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" value="Update"/>
                <input type="button" value="Cancel"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
