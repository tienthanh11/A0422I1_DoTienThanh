<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2022
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<center>
    <h2>Mượn sách</h2>
    <c:if test="${message!=null}">
        <h3 class="text-primary">${message}</h3>
    </c:if>
</center>
<form method="get" class="container w-50">
    <div>
        <div class="input-group my-4">
            <div class="input-group-prepend">
                <span class="input-group-text">Mã mượn sách</span>
            </div>
            <input value="${cardBorrowBook.cardBorrowBookId}" name="id" type="text" aria-label="Last name" class="form-control">
            <small class="col-md-12 " style="color: red"> ${error.id}  </small>
        </div>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                <span class="input-group-text">Tên sách</span>
            </div>
            <c:forEach items="${bookList}" var="book">
                <c:if test="${book.bookId == cardBorrowBook.bookId}">
                    <input value="${book.name}" name="bookId" type="text" aria-label="Last name" class="form-control">
                </c:if>
            </c:forEach>
            <small class="col-md-12" style="color: red"> ${error.area}</small>
        </div>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                <span class="input-group-text">Tên học sinh</span>
            </div>
            <c:forEach items="${studentList}" var="student">
                <c:if test="${student.studentId == cardBorrowBook.studentId}">
                    <input value="${student.name}" name="bookId" type="text" aria-label="Last name" class="form-control">
                </c:if>
            </c:forEach>
            <small class="col-md-12" style="color: red"> ${error.area}</small>
        </div>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                <span class="input-group-text">Ngày mượn sách</span>
            </div>
            <input value="${cardBorrowBook.dateBorrow}" name="dateBorrow" type="date" aria-label="Last name" class="form-control">
            <small class="col-md-12" style="color: red"> ${error.area}</small>
        </div>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                <span class="input-group-text">Ngày trả sách</span>
            </div>
            <input value="${cardBorrowBook.dateTurn}" name="dateReturn" type="date" aria-label="Last name" class="form-control">
            <small class="col-md-12" style="color: red"> ${error.area}</small>
        </div>
        <div class="form-inline d-flex justify-content-center">
            <button type="submit" class="btn btn-outline-info mx-2x mr-1">Mượn sách</button>
            <a href="/book "> <button type="button" class="btn btn-outline-info ">Hủy</button></a>
        </div>
    </div>
</form>
</body>
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<script src="template/jquery-3.6.0.min.js"></script>
</html>
