<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<%--++++++++++++++hiển thị+++++++++++--%>
<div>
    <center>
        <br>
        <h1 class="font-text-footer" style="color: #cbbe73">Product List</h1>

        <c:if test="${mess != null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>

        <br><br>
        <%--++++++++++++++++++form search++++++++++++++--%>
        <div class="container d-flex justify-content-center">
            <form action="/product" method="get">
                <div class="input-group mb-3">
                    <span class="input-group-text">Name product</span>
                    <input type="text" class="ms-2" name="nameProductSearch" placeholder="Nhập tên product"
                           value="${nameProductSearch}">
                    <button type="submit" name="action" class="btn btn-success" value="search">Search</button>
                </div>
            </form>
        </div>
    </center>
    <br>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Category</th>
                <th colspan="2">
                    <a href="/product?action=create">
                        <button class="btn btn-secondary w-100">Create</button>
                    </a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.color}</td>

                    <c:forEach var="category" items="${categoryList}">
                        <c:if test="${product.categoryId == category.id}">
                            <td>${category.name}</td>
                        </c:if>
                    </c:forEach>

                    <td>
                        <a href="/product?action=edit&id=${product.id}">
                            <button class="btn btn-primary">Edit</button>
                        </a>
                    </td>

                    <td>
                        <!-- Button trigger modal -->
                        <button type="button" onclick="showInfo('${product.id}', '${product.name}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <%-----------thêm thẻ form---------%>
        <form action="/product" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá!</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="idProduct" name="idDelete" hidden>
                    <span>Bạn có muốn xoá Product </span>
                    <span class="text-danger" id="idValueProduct"></span><span> không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" name="action" value="delete">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="template/jquery-3.6.0.min.js"></script>
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<script>
    function showInfo(id, value) {
        document.getElementById("idProduct").value = id;
        document.getElementById("idValueProduct").innerText = value;
    }
</script>
</html>
