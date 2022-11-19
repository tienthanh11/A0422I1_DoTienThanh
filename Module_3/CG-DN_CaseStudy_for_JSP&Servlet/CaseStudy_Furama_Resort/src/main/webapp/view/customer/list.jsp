<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/7/2022
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
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
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/template/layout/sidebar.jsp"/>
        <div class="col-md-10">
            <br>
            <center>
                <h1 class="font-text-footer">Customer List</h1>
                <c:if test="${mess != null}">
                    <h2 class="text-danger">${mess}</h2>
                </c:if>
            </center>
            <br>
            <table id="tableCustomer" class="table table-hover">
                <thead>
                <th>ID</th>
                <th>Type Name</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Id Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th></th>
                <th>
                    <a href="/customer?action=create">
                        <button type="button" class="btn btn-warning btn-outline-primary w-100">Create</button>
                    </a>
                </th>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customerType.customerTypeId == customer.customerTypeId}">
                                <td>${customerType.customerTypeName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${customer.customerName}</td>
                        <td style="width: 90px;">${customer.customerBirthday}</td>
                        <c:if test="${customer.customerGender == 0}">
                            <td>Nữ</td>
                        </c:if>
                        <c:if test="${customer.customerGender == 1}">
                            <td>Nam</td>
                        </c:if>
                        <td>${customer.customerIdCard}</td>
                        <td>${customer.customerPhone}</td>
                        <td style="word-break: break-word">${customer.customerEmail}</td>
                        <td style="word-break: break-word">${customer.customerAddress}</td>
                        <td>
                            <a href="/customer?action=edit&id=${customer.customerId}">
                                <button class="btn text-light btn-success btn-outline-secondary">Edit</button>
                            </a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button"
                                    onclick="showInfo('${customer.customerId}', '${customer.customerName}')"
                                    class="btn btn-success text-light btn-outline-dark" data-bs-toggle="modal"
                                    data-bs-target="#deleteModal">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- footer --%>
<div>
    <jsp:include page="/template/layout/footer.jsp"/>
</div>
</body>

<!-- Modal Delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <%-- thêm thẻ form --%>
        <form action="/customer" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="idCustomer" name="idDelete" hidden>
                    <span>Bạn có muốn xoá Customer </span>
                    <span class="text-danger" id="nameCustomer"></span><span> không ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" name="action" value="delete">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

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
