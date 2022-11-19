<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ground Management</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<div class="container">
    <br>
    <h1 class="text-primary" style="text-align: center">Ground List</h1>
    <%--******************** Form để search *************************--%>
    <br>
    <form method="get" class="container w-50">
        <div class="form-inline" style="margin-left: -15px">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="1">Loại mặt bằng</label>
                </div>
                <select name="typeOfficeSearch" class="custom-select" id="1">
                    <option value="" selected>Cho thuê</option>
                    <c:forEach var="typeOffice" items="${typeOfficeList}">
                        <option value="${typeOffice.typeOfficeId}">${typeOffice.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="2">Tầng</label>
                </div>
                <select name="floorsSearch" class="custom-select" id="2">
                    <option value="">Chọn</option>
                    <c:forEach var="listFloors" items="${listFloors}">
                        <option>${listFloors}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Giá cho thuê</span>
                </div>
                <input name="priceSearch" placeholder="Từ" type="text" aria-label="First name"
                       class="form-control mx-3">
                <input name="endRentalPriceSearch" placeholder="Đến" type="text" aria-label="Last name"
                       class="form-control mr-3">
            </div>
        </div>
        <center>
            <button type="submit" name="action" value="search" class="btn btn-outline-info ">Search</button>
            <a href="/ground?action=create">
                <button type="button" name="action" value="create" class="btn btn-outline-info ">Create</button>
            </a>
        </center>
    </form>

    <center>
        <c:if test="${message != null}">
            <h3 class="text-danger">${message}</h3>
        </c:if>
        <br>
        <table class="table table-sm text-center">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã Mặt Bằng</th>
                <th scope="col">Diện tích</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Tầng</th>
                <th scope="col">Loại văn phòng</th>
                <th scope="col">Giá cho thuê</th>
                <th scope="col">Ngày bắt đầu</th>
                <th scope="col">Ngày kết thúc</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ground" items="${groundList}" varStatus="dem">
                <tr>
                    <td>${dem.count}</td>
                    <td>${ground.id}</td>
                    <td>${ground.area}</td>
                    <c:forEach var="status" items="${statusList}">
                        <c:if test="${status.statusId == ground.statusId}">
                            <td>${status.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${ground.floors}</td>
                    <c:forEach var="typeOffice" items="${typeOfficeList}">
                        <c:if test="${typeOffice.typeOfficeId==ground.typeOfficeId}">
                            <td>${typeOffice.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${ground.rentalPrice}</td>
                    <td>${ground.startDate}</td>
                    <td>${ground.endDate}</td>
                    <td>
                        <a href="/ground?action=edit&id=${ground.id}">
                            <button type="button" class="btn btn-outline-info text-dark">
                                Edit
                            </button>
                        </a>

                        <!-- Button trigger modal -->
                        <button type="button" onclick="showInfo('${ground.id}', '${ground.id}')"
                                class="btn btn-outline-info text-dark" data-bs-toggle="modal"
                                data-bs-target="#deleteModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </center>
</div>

<!-- Modal Delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/ground" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="idGround" name="id" hidden>
                    <span>Bạn có muốn xoá mặt bằng với mã </span>
                    <span class="text-danger" id="nameGround"></span> <span> không?</span>
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
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<script src="template/jquery-3.6.0.min.js"></script>
<script src="template/datatable/js/jquery.dataTables.min.js"></script>
<script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableList').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        });
    });
</script>
<script>
    function showInfo(id, name) {
        document.getElementById("idGround").value = id;
        document.getElementById("nameGround").innerText = name;
    }
</script>
</html>
