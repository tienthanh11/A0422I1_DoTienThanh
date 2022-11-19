<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2022
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<%--+++++++++content++++++++--%>
<div>
    <center>
        <br>
        <h1 class="font-text-footer" style="color: #cbbe73">Create Product</h1>
        <c:if test="${mess != null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>
        <br><br>
        <div class="container">
            <form action="/product?action=create" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text">Name</span>
                    <input type="text" name="name" class="form-control me-2" placeholder="Name" value="${product.name}"
                           required>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Price</span>
                    <input type="text" name="price" class="form-control me-2" placeholder="Price"
                           value="${product.price}" required>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Quantity</span>
                    <input type="number" name="quantity" class="form-control me-2" placeholder="Quantity"
                           value="${product.quantity}" required>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Color</span>
                    <input type="text" name="color" class="form-control me-2" placeholder="Color"
                           value="${product.color}" required>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Describe</span>
                    <input type="text" name="describe" class="form-control me-2" placeholder="Describe"
                           value="${product.describe}" required>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Type(*)</span>
                    <select name="categoryId" class="me-2">
                        <option value="">--- Chọn ---</option>
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="input-group mb-5 d-flex align-content-center justify-content-center">
                    <button type="submit" class="btn btn-primary">Create</button>
                    <button type="button" class="btn btn-secondary ms-3">
                        <a style="text-decoration: none" class="text-light" href="/product">
                            Back to list
                        </a>
                    </button>
                </div>
            </form>
        </div>
    </center>
</div>
</body>
<script src="template/jquery-3.6.0.min.js"></script>
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>
