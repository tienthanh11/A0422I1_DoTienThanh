<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/26/2022
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <h2>
        <p>Find by country</p>
        <input type="text" id="find-country"/>
        <a class="btn-find" href="/users?action=find&id=" type="button">Find by Country</a>
        <a href="/users" type="button">Back to list</a>

        <script>
            /*$('.btn-find').click(function () {
              let country=$('#find-country').val();
              $('.btn-find').attr("href", "/users?action=fin &id=" + country);
            })*/
        </script>
    </h2>
    <h2>
        <a href="/users?action=sort">Sort by name</a>
    </h2>
</center>
<c:if test="${empty listUser}">
    <h1 style="color: red; text-align: center">User List Empty</h1>
</c:if>
<c:if test="${not empty listUser}">
    <div align="center">
        <table border="1" cellpadding="5">
            <h3>List of Users</h3>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${requestScope['listUser']}" varStatus="c">
                <tr>
                    <td><c:out value="${c.count}"/></td>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <a href="/users?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
