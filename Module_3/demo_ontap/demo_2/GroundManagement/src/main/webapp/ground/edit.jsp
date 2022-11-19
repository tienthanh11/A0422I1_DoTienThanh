<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Ground</title>
    <link rel="stylesheet" href="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<center>
    <h2 class="text-primary">Edit Ground</h2>
    <c:if test="${message!=null}">
        <h3 class="text-primary">${message}</h3>
    </c:if>

    <form method="post" class="container w-50">
        <div>
            <div class="input-group my-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Mã mặt bằng (*)</span>
                </div>
                <input readonly value="${ground.id}" name="id" type="text" aria-label="Last name" class="form-control">
                <small class="col-md-12 " style="color: red"> ${error.id} </small>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Diện tích (*)</span>
                </div>
                <input value="${ground.area}" name="area" type="text" aria-label="Last name" class="form-control">
                <small class="col-md-12" style="color: red"> ${error.area}</small>
            </div>

            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Trạng thái (*)</span>
                </div>
                <select name="status">
                    <c:forEach items="${statusList}" var="status">
                        <c:if test="${status.statusId == ground.statusId}">
                            <option value="${status.statusId}" selected>${status.name}</option>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${statusList}" var="status">
                        <c:if test="${status.statusId != ground.statusId}">
                            <option value="${status.statusId}">${status.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Tầng (*)</span>
                </div>
                <select name="floors">

                    <c:forEach items="${listFloors}" var="listFloors">
                        <c:if test="${listFloors == ground.floors}">
                            <option value="${listFloors}">${listFloors}</option>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listFloors}" var="listFloors">
                        <c:if test="${listFloors != ground.floors}">
                            <option value="${listFloors}">${listFloors}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Loại văn phòng (*)</span>
                </div>
                <select name="typeOffice">
                    <c:forEach items="${typeOfficeList}" var="typeOffice">
                        <c:if test="${typeOffice.typeOfficeId == ground.typeOfficeId}">
                            <option value="${typeOffice.typeOfficeId}" selected>${typeOffice.name}</option>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${typeOfficeList}" var="typeOffice">
                        <c:if test="${typeOffice.typeOfficeId != ground.typeOfficeId}">
                            <option value="${typeOffice.typeOfficeId}">${typeOffice.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group my-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Mô tả chi tiết (*)</span>
                </div>
                <textarea name="description" rows="2" style="width: 80%">${ground.description}</textarea>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text">Giá cho thuê (*)</span>
                </div>
                <input value="${ground.rentalPrice}" name="rentalPrice" type="text" aria-label="Last name"
                       class="form-control">
                <div class="input-group-append">
                    <span class="input-group-text">VND</span>
                </div>
                <small class="col-md-12" style="color: red"> ${error.rentalPrice} </small>
            </div>
            <div class="form-inline d-flex justify-content-between my-4">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Ngày bắt đầu (*)</span>
                    </div>
                    <input value="${ground.startDate}" name="startDate" type="date" aria-label="Last name"
                           class="form-control">
                </div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Ngày kết thúc (*)</span>
                    </div>
                    <input value="${ground.endDate}" name="endDate" type="date" aria-label="Last name" class="form-control">
                </div>
                <small class="col-md-12 text-center" style="color: red"> ${error.date}</small>
            </div>
            <div class="form-inline d-flex justify-content-center">
                <button type="submit" class="btn btn-outline-info mx-2x mr-1">Edit</button>
                <a href="/ground ">
                    <button type="button" class="btn btn-outline-info ">Back to list</button>
                </a>
            </div>
        </div>
    </form>
</center>

</body>
<script src="template/bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<script src="template/jquery-3.6.0.min.js"></script>
<script src="template/datatable/js/jquery.dataTables.min.js"></script>
<script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
</html>
