<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2022
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="template/datatable/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="template/style.css">
</head>
<body>
<%-- header --%>
<div>
    <jsp:include page="/template/layout/header.jsp"/>
</div>

<!-- navbar top -->
<div class="mt-2 sticky-top" style="background-color: aquamarine">
    <nav class="navbar navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand text-primary ps-5 click" href="/home">Home</a>
            <a class="navbar-brand text-primary click" href="/employee">Employee</a>
            <a class="navbar-brand text-primary click" href="/customer">Customer</a>
            <a class="navbar-brand text-primary click" href="/service">Service</a>
            <a class="navbar-brand text-primary click" href="/contract">Contract</a>
            <form class="d-flex m-0" action="/customer" method="get">
                <label for="type"></label>
                <select id="type" name="typeSearch" class="form-control me-2">
                    <option value="">Choose</option>
                    <c:forEach var="customer" items="${customerTypeList}">
                        <option value="${customer.customerTypeId}">${customer.customerTypeName}</option>
                    </c:forEach>
                </select>
                <input style="width: 140px" class="form-control me-2 " type="search" name="nameSearch"
                       placeholder="Input name" aria-label="name">
                <input style="width: 140px" class="form-control me-2" type="search" name="addressSearch"
                       placeholder="Input address" aria-label="Search">
                <button type="submit" name="action" value="search" class="btn btn-warning btn-outline-primary">
                    Search
                </button>
            </form>
        </div>
    </nav>
</div>

<!-- content -->
<div class="row">
    <jsp:include page="/template/layout/sidebar.jsp"/>
    <div class="col-md-10 container">
        <br>
        <center>
            <h1 class="font-text-footer">Edit Customer</h1>
            <c:if test="${mess !=null}">
                <h2 class="text-danger">${mess}</h2>
            </c:if>
            <br><br>
            <div class="container">
                <form action="/customer?action=edit&id=${customer.customerId}" method="post">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" name="name" class="form-control me-2" value="${customer.customerName}">

                        <span class="input-group-text">Gender</span>
                        <c:if test="${customer.customerGender == 1}">
                            <select name="gender" class="me-2">
                                <option value="1">Nam</option>
                                <option value="0">N???</option>
                            </select>
                        </c:if>
                        <c:if test="${customer.customerGender == 0}">
                            <select name="gender" class="me-2">
                                <option value="0">N???</option>
                                <option value="1">Nam</option>
                            </select>
                        </c:if>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Birthday</span>
                        <input type="date" name="birthday" class="form-control me-2"
                               value="${customer.customerBirthday}">

                        <span class="input-group-text">Type</span>
                        <select name="type" class="me-2">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <c:if test="${customerType.customerTypeId == customer.customerTypeId}">
                                    <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                                </c:if>
                            </c:forEach>

                            <c:forEach var="customerType" items="${customerTypeList}">
                                <c:if test="${customerType.customerTypeId != customer.customerTypeId}">
                                    <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Id Card</span>
                        <input type="text" name="idCard" class="form-control me-2" value="${customer.customerIdCard}">

                        <span class="input-group-text">Phone</span>
                        <input type="text" name="phone" class="form-control me-2" value="${customer.customerPhone}">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Email</span>
                        <input type="text" name="email" class="form-control me-2" value="${customer.customerEmail}">

                        <span class="input-group-text">Address</span>
                        <input type="text" name="address" class="form-control me-2" value="${customer.customerAddress}">
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary">Edit</button>
                    <a href="/customer" class="btn btn-secondary" role="button">Back to list</a>
                </form>
            </div>
        </center>
    </div>
</div>

<%-- footer --%>
<div>
    <jsp:include page="/template/layout/footer.jsp"/>
</div>
</body>
<script src="template/bootstrap/jquery-3.6.0.min.js"></script>
<script src="template/datatable/js/jquery.dataTables.min.js"></script>
<script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
<script src="template/main.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        });
    });

    function showInfo(id, name) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("nameCustomer").innerText = name;
    }
</script>

</html>
