<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/17/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service List</title>
    <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="template/datatable/css/dataTables.bootstrap4.css">
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
            <form class="d-flex m-0" action="/service" method="get">
                <input style="width: 140px" class="form-control me-2 " type="search" name="nameSearch"
                       placeholder="Input name" aria-label="name">
                <label for="type"></label>
                <select id="rentType" name="rentTypeSearch" class="form-control me-2">
                    <option value="">Choose Rent Type</option>
                    <c:forEach var="service" items="${rentTypeList}">
                        <option value="${service.rentTypeId}">${service.rentTypeName}</option>
                    </c:forEach>
                </select>
                <select id="type" name="serviceTypeSearch" class="form-control me-2">
                    <option value="">Choose Type</option>
                    <c:forEach var="service" items="${serviceTypeList}">
                        <option value="${service.serviceTypeId}">${service.serviceTypeName}</option>
                    </c:forEach>
                </select>
                <label for="rentType"></label>

                <button type="submit" name="action" value="search" class="btn btn-warning btn-outline-primary">
                    Search
                </button>
            </form>
        </div>
    </nav>
</div>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="/template/layout/sidebar.jsp"/>
        <div class="col-md-10" style="overflow-x: hidden; overflow-y : hidden;">
            <br>
            <center>
                <h1 class="font-text-footer">Service List</h1>
                <c:if test="${mess !=null}">
                    <h2 class="text-danger">${mess}</h2>
                </c:if>
            </center>
            <br>
            <table id="tableService" class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max people</th>
                    <th>Rent Type</th>
                    <th>Type</th>
                    <th>Standard Room</th>
                    <th>Description</th>
                    <th>Pool Area</th>
                    <th>Floors</th>
                    <th></th>
                    <th>
                        <a href="/service?action=create">
                            <button class="btn btn-warning btn-outline-primary w-100">Create</button>
                        </a>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <td>${service.serviceId}</td>
                        <td>${service.serviceName}</td>
                        <td>${service.serviceArea}</td>
                        <td>${service.serviceCost}</td>
                        <td>${service.serviceMaxPeople}</td>
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <c:if test="${service.rentTypeId == rentType.rentTypeId}">
                                <td>${rentType.rentTypeName}</td>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:if test="${service.serviceTypeId == serviceType.serviceTypeId}">
                                <td>${serviceType.serviceTypeName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${service.standardRoom}</td>
                        <td>${service.descriptionOtherConvenience}</td>
                        <td>${service.poolArea}</td>
                        <td>${service.numberOfFloors}</td>
                        <td>
                            <a href="/service?action=edit&id=${service.serviceId}">
                                <button type="button" class="btn text-light btn-success btn-outline-secondary">
                                    Edit
                                </button>
                            </a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" onclick="showInfo('${service.serviceId}', '${service.serviceName}')"
                                    class="btn text-light btn-success btn-outline-secondary" data-bs-toggle="modal"
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
        <form action="/service" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden type="text" id="serviceId" name="id">
                    <span>Bạn có muốn xóa dịch vụ </span>
                    <span class="text-danger" id="serviceName"></span> không?<span/>
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
<script src="template/bootstrap/js/bootstrap.js"></script>
<script src="template/datatable/js/jquery.dataTables.min.js"></script>
<script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
<script src="template/main.js"></script>

<script>
    $(document).ready(function () {
        $('#tableService').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        });
    });

    function showInfo(id, name) {
        document.getElementById("serviceId").value = id;
        document.getElementById("serviceName").innerText = name;
    }
</script>
</html>
