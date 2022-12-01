<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<a href="/add">Khai báo Y Tế</a>
<br><br>
<table border="2" style="border-collapse:collapse; text-align: center">
    <c:forEach var="list" items="${list}" varStatus="status">
        <tr>
            <td><h3>Thông tin ${status.count}</h3></td>
        </tr>
        <tr>
            <td><p>Họ và tên: </p></td>
            <td>${list.hoTen}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><p>Năm Sinh: </p></td>
            <td>${list.namSinh}</td>
            <td><p>Giới Tính: </p></td>
            <td>${list.gioiTinh}</td>
            <td><p>Quốc Tịch: </p></td>
            <td>${list.quocTich}</td>
            <td><p>Số CMND: </p></td>
            <td>${list.soCMND}</td>
        </tr>
        <tr>
            <td><p>Tên Phương Tiện: </p></td>
            <td>${list.tenPhuongTien}</td>
            <td><p>Số Hiệu Phương Tiện: </p></td>
            <td>${list.soHieuPhuongTien}</td>
            <td><p>Số Ghế: </p></td>
            <td>${list.soGhe}</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><p>Ngày Khởi Hành: </p></td>
            <td>${list.ngayKhoiHanh}</td>
            <td><p>Ngày Kết Thúc: </p></td>
            <td>${list.ngayKetThuc}</td>
            <td><p>Nơi Đã Đến</p></td>
            <td>${list.noiDaDen}</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><h3>Địa Chỉ Liên Lạc</h3></td>
        </tr>
        <tr>
            <td><p>Thành Phố/Tỉnh: </p></td>
            <td>${list.thanhPho}</td>
            <td><p>Quận/Huyện: </p></td>
            <td>${list.quan}</td>
            <td><p>Phường/Xã: </p></td>
            <td>${list.phuong}</td>
            <td>Địa Chỉ Nơi Ở:</td>
            <td>${list.noiO}</td>
        </tr>
        <tr>
            <td><p>Điện Thoại: </p></td>
            <td>${list.soDienThoai}</td>
            <td><p>Email: </p></td>
            <td>${list.email}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><h3>Trong vòng 14 ngày qua, có những biểu hiện</h3></td>
        </tr>
        <tr>
            <td><p>Triệu Chứng Sốt: </p></td>
            <td>${list.trieuChungSot}</td>
            <td><p>Triệu Chứng Ho: </p></td>
            <td>${list.trieuChungHo}</td>
            <td><p>Triệu Chứng Khó Thở: </p></td>
            <td>${list.trieuChungKhoTho}</td>
            <td>Triệu Chứng Đau Họng:</td>
            <td>${list.trieuChungDauHong}</td>
        </tr>
        <tr>
            <td><p>Triệu Chứng Nôn: </p></td>
            <td>${list.trieuChungNon}</td>
            <td><p>Triệu Chứng Tiêu Chảy: </p></td>
            <td>${list.trieuChungTieuChay}</td>
            <td><p>Triệu Chứng Xuất Huyết: </p></td>
            <td>${list.trieuChungXuatHuyet}</td>
            <td>Triệu Chứng Nỗi Ban:</td>
            <td>${list.trieuChungNoiBan}</td>
        </tr>
        <tr>
            <td><h3>Trong vòng 14 ngày qua, có: </h3></td>
        </tr>
        <tr>
            <td><p>Đến nơi đông người: </p></td>
            <td>${list.lichSuDenNoiNhiem}</td>
            <td><p>Tiếp xúc gần với người nhiễm : </p></td>
            <td>${list.lichSuTiepXuc}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>