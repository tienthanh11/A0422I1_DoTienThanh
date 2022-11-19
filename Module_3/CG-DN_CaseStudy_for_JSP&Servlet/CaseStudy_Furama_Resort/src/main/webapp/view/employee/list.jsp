<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/3/2022
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
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
            <form class="d-flex m-0" action="/employee" method="get">
                <input style="width: 140px" class="form-control me-2 " type="search" name="nameSearch"
                       placeholder="Input Name" value="${nameSearch}" aria-label="name">
                <label for="type"></label>
                <select id="rentType" name="positionSearch" class="form-control me-2">
                    <option value="">Choose Position</option>
                    <c:forEach var="position" items="${positionList}">
                        <option value="${position.positionId}">${position.positionName}</option>
                    </c:forEach>
                </select>
                <select id="type" name="divisionSearch" class="form-control me-2">
                    <option value="">Choose Division</option>
                    <c:forEach var="division" items="${divisionList}">
                        <option value="${division.divisionId}">${division.divisionName}</option>
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
        <%@include file="/template/layout/sidebar.jsp" %>
        <div class="col-md-10">
            <br>
            <center>
                <h1 class="font-text-footer">Employee List</h1>
                <c:if test="${mess !=null}">
                    <h2 class="text-danger">${mess}</h2>
                </c:if>
            </center>
            <br>
            <table id="tableEmployee" class="table table-hover" style="font-size: 12px; display: grid">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Id Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Education Degree</th>
                    <th>Division</th>
                    <th>Username</th>
                    <th></th>
                    <th><a href="/employee?action=create">
                        <button class="btn btn-warning btn-outline-primary w-100">Create</button>
                    </a></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.employeeName}</td>
                        <td style="width: 90px">${employee.employeeBirthday}</td>
                        <td>${employee.employeeIdCard}</td>
                        <td>${employee.employeeSalary}</td>
                        <td>${employee.employeePhone}</td>
                        <td>${employee.employeeEmail}</td>
                        <td>${employee.employeeAddress}</td>
                        <c:forEach var="position" items="${positionList}">
                            <c:if test="${position.positionId == employee.positionId}">
                                <td>${position.positionName}</td>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="education" items="${educationDegreeList}">
                            <c:if test="${employee.educationDegreeId == education.educationDegreeId}">
                                <td>${education.educationDegreeName}</td>
                            </c:if>
                        </c:forEach>
                        <c:forEach items="${divisionList}" var="division">
                            <c:if test="${employee.divisionId == division.divisionId}">
                                <td>${division.divisionName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${employee.username}</td>
                        <td>
                            <a href="/employee?action=edit&id=${employee.employeeId}">
                                <button class="btn text-light btn-success btn-outline-secondary">Edit</button>
                            </a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button"
                                    onclick="showInfo('${employee.employeeId}','${employee.employeeName}')"
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
        <%-- thêm thẻ form --%>
        <form action="/employee" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="idEmployee" name="id" hidden>
                    <span>Bạn có muốn xoá Employee</span>
                    <span class="text-danger" id="nameEmployee"></span><span> không?</span>
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
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        });
    });

    function showInfo(id, name) {
        document.getElementById("idEmployee").value = id;
        document.getElementById("nameEmployee").innerText = name;
    }
</script>
</html>
