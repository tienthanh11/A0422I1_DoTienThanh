<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2022
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Create</title>
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

<%-- content --%>
<div class="row">
    <jsp:include page="/template/layout/sidebar.jsp"/>
    <div class="col-md-10 container">
        <br>
        <center>
            <h1 class="font-text-footer">Create Employee</h1>
            <c:if test="${mess != null}">
                <h2 class="text-danger">${mess}</h2>
            </c:if>
            <br><br>
            <div class="container">
                <form action="/employee?action=create" method="post" name="formCreate">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" name="name" class="form-control me-2" placeholder="Name Employee"
                               value="${employeeName}">

                        <span class="input-group-text">Birthday</span>
                        <input type="date" name="birthday" class="form-control me-2" placeholder="Birthday"
                               value="${employeeBirthday}">

                        <span class="input-group-text">Id Card</span>
                        <input type="text" name="idCard" class="form-control me-2" placeholder="Id Card"
                               value="${employeeIdCard}">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Salary</span>
                        <input type="text" name="salary" class="form-control me-2" placeholder="Salary"
                               value="${employeeSalary}">

                        <span class="input-group-text">Phone</span>
                        <input type="text" name="phone" class="form-control me-2" placeholder="Phone Number"
                               value="${employeePhone}">

                        <span class="input-group-text">Email</span>
                        <input type="text" name="email" class="form-control me-2" placeholder="Email"
                               value="${employeeEmail}">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Position</span>
                        <select name="positionId" class="me-2">
                            <c:if test="${positionId == null}">
                                <option>Choose</option>
                                <c:forEach var="position" items="${positionList}">
                                    <option value="${position.positionId}">${position.positionName}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${positionId != null}">
                                <c:forEach var="position" items="${positionList}">
                                    <c:if test="${position.positionId == employee.positionId}">
                                        <option value="${position.positionId}">${position.positionName}</option>
                                    </c:if>
                                </c:forEach>

                                <c:forEach var="position" items="${positionList}">
                                    <c:if test="${position.positionId != employee.positionId}">
                                        <option value="${position.positionId}">${position.positionName}</option>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </select>

                        <span class="input-group-text">Education Degree</span>
                        <select name="educationDegreeId" class="me-2">
                            <c:if test="${educationDegreeId == null}">
                                <option value="">Choose</option>
                                <c:forEach var="educationDegree" items="${educationDegreeList}">
                                    <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${educationDegreeId != null}">
                                <c:forEach var="educationDegree" items="${educationDegreeList}">
                                    <c:if test="${educationDegree.educationDegreeId == employee.educationDegreeId}">
                                        <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="educationDegree" items="${educationDegreeList}">
                                    <c:if test="${educationDegree.educationDegreeId != employee.educationDegreeId}">
                                        <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </select>

                        <span class="input-group-text">Division</span>
                        <select name="divisionId" class="me-2">
                            <c:if test="${divisionId == null}">
                                <option value="">Choose</option>
                                <c:forEach var="division" items="${divisionList}">
                                    <option value="${division.divisionId}">${division.divisionName}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${divisionId != null}">
                                <c:forEach var="division" items="${divisionList}">
                                    <c:if test="${division.divisionId == employee.divisionId}">
                                        <option value="${division.divisionId}">${division.divisionName}</option>
                                    </c:if>
                                </c:forEach>

                                <c:forEach var="division" items="${divisionList}">
                                    <c:if test="${division.divisionId != employee.divisionId}">
                                        <option value="${division.divisionId}">${division.divisionName}</option>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Address</span>
                        <input type="text" name="address" class="form-control me-2" placeholder="Address"
                               value="${employeeAddress}">

                        <span class="input-group-text">Username</span>
                        <input type="text" name="username" class="form-control me-2" placeholder="Username"
                               value="${username}">
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary">Create</button>
                    <a href="/employee" class="btn btn-secondary" role="button">Back to list</a>
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
