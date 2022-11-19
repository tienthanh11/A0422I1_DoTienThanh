<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2022
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<html>
<head>
    <title>Them moi</title>
</head>
<style>
    .back {
        text-decoration: none;
        color: black;
    }

    .back:hover {
        color: white;
    }

    .content {
        border: 1px solid black;
        width: 400px;
        padding-left: 50px;
        border-radius: 10px;
        box-shadow: 10px 10px 5px black;
        margin-left: 500px;
        font-size: 20px;
        height: 490px;
    }

    .click:hover {
        color: white;
        background-color: black;
        border-radius: 10px;
        cursor: pointer;
    }

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
</style>
<body>
<div class="content">
    <div>
        <h1>Add New Product</h1>
        <c:if test="${mess!=null}">
            <p style="color: red">${mess}</p>
        </c:if>
        <form action="/room?action=create" method="post">
            <pre>Tên Người Thuê    : <input required type="text" name="tenNguoiThue"></pre>
            <pre>SĐT               : <input id="std" required type="number" name="sDT"> </pre>
            <pre>Ngày Bắt Đầu Thuê : <input type="date" name="ngayBatDau"></pre>
            <pre>Hình Thức         : <select style="font-size: 20px; width: 100px" name="idHinhThuc">
                     <c:forEach var="cls" items="${paymentList}">
                         <option value="${cls.id}">${cls.namePayment}</option>
                     </c:forEach>
                    </select></pre>
            <button class="click" style="font-size: 20px; width: 100px" type="submit">Create</button>
        </form>
    </div>

    <button class="click" style="font-size: 20px; width: 100px">
        <a class="back" href="/room">Back </a>
    </button>
</div>
</body>
</html>

