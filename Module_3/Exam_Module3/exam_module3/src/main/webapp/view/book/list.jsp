<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2022
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sách</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<center>
    <h2 class="m-4">Danh sách sách</h2>
    <c:if test="${message!=null}">
        <h3 class="text-primary">${message}</h3>
    </c:if>
    <form action="/book?action=search">
        <input name="nameSearch" type="text">
        <button type="submit" name="action" value="search" class="btn btn-outline-info ">Search</button>
    </form>
    <table class="table table-sm text-center">
        <thead>
        <tr>
            <th scope="col">Mã sách</th>
            <th scope="col">Tên sách</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookList}" var="book" varStatus="status">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.quantity}</td>
                <td>${book.description}</td>
                <td>
                    <a href="/borrow?id=${book.bookId}">
                        <button type="button" class="btn text-light btn-success btn-outline-secondary">
                            Mượn sách
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<script src="template/jquery-3.6.0.min.js"></script>
</html>
