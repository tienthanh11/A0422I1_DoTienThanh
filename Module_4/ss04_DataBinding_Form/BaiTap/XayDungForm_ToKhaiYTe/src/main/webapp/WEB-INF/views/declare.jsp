<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TỜ KHAI Y TẾ</title>
</head>
<body>

<div style="text-align: center">
    <h2>TỜ KHAI Y TẾ</h2>
    <strong>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
        CHỐNG DỊCH BỆNH TRUYÊN NHIỄM</strong>
    <br><br>
    <strong style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý
        hình sự</strong>
</div>
<form:form action="/add" method="post" modelAttribute="medical">
    <table style="width: 90%; margin: 0 auto">
        <tr>
            <td>
                <label>Họ tên (ghi chữ IN HOA)</label>
            </td>
        </tr>
        <tr>
            <td>
                <form:input path="hoTen" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Năm Sinh</label>
            </td>
            <td>
                <label>Giới Tính</label>
            </td>
            <td>
                <label>Quốc Tịch</label>
            </td>
        </tr>
        <tr>
            <td>
                <form:select path="namSinh">
                    <c:forEach var="i" begin="1900" end="2022" step="1">
                        <form:option value="${i}">${i}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td>
                <form:select path="gioiTinh">
                    <form:options items="${listGender}"></form:options>
                </form:select>
            </td>
            <td>
                <form:select path="quocTich">
                    <form:options items="${listQuocTich}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
            </td>
        </tr>
        <tr>
            <td>
                <form:input path="soCMND" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                Thông tin đi lại
            </td>
        </tr>
        <tr>
            <td>

            </td>
        </tr>
        <tr>
            <td>Số Hiệu Phương Tiện</td>
            <td>Số Ghế</td>
        </tr>
        <tr>
            <td>
                <form:input path="soHieuPhuongTien" type="text"/>
            </td>
            <td>
                <form:input path="soGhe" type="text"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <h3>Ngày Khởi Hành </h3>
            </td>
            <td colspan="3">
                <h3>Ngày kết thúc</h3>
            </td>

        </tr>
        <tr>
            <td>
                <select name="ngayKhoiHanh">
                    <c:forEach var="i" begin="1" end="30" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="thangKhoiHanh">
                    <c:forEach var="i" begin="1" end="12" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="namKhoiHanh">
                    <c:forEach var="i" begin="1980" end="2022" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="ngayKetThuc">
                    <c:forEach var="i" begin="1" end="30" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="thangKetThuc">
                    <c:forEach var="i" begin="1" end="12" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="namKetThuc">
                    <c:forEach var="i" begin="1980" end="2022" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</td>
        </tr>
        <tr>
            <td>
                <form:input path="noiDaDen" type="text"/>
            </td>
        </tr>
        <tr>
            <td><h3>
                Địa Chỉ Liên Lạc
            </h3></td>
        </tr>
        <tr>
            <td>Tỉnh/Thành</td>
            <td>Quận/Huyện</td>
            <td>Phường/Xã</td>
        </tr>
        <tr>
            <td>
                <form:select path="thanhPho">
                    <form:options items="${listQuocTich}"></form:options>
                </form:select>
            </td>
            <td>
                <form:select path="quan">
                    <form:options items="${listQuocTich}"></form:options>
                </form:select>
            </td>
            <td>
                <form:select path="phuong">
                    <form:options items="${listQuocTich}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><h3>
                Địa chỉ nơi ở
            </h3></td>
        </tr>
        <tr>
            <td>
                <form:input path="noiO" type="text"/>
            </td>
        </tr>
        <tr>
            <td>Điện thoại</td>
            <td>Email</td>
        </tr>
        <tr>
            <td>
                <form:input path="soDienThoai" type="text"/>
            </td>
            <td>
                <form:input path="email" type="text"/>
            </td>
        </tr>
        <tr>
            <td><h3>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào không?</h3></td>
        </tr>
        <tr>
            <table style="width: 100%; text-align: center">
                <tr>
                    <th>Triệu Chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                    <th>Triệu Chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Sốt</td>
                    <td><form:radiobutton path="trieuChungSot" value="true"/></td>
                    <td><form:radiobutton path="trieuChungSot" value="false"/></td>
                    <td>Nôn/Buồn Nôn</td>
                    <td><form:radiobutton path="trieuChungNon" value="true"/></td>
                    <td><form:radiobutton path="trieuChungNon" value="false"/></td>
                </tr>
                <tr>
                    <td>Ho</td>
                    <td><form:radiobutton path="trieuChungHo" value="true"/></td>
                    <td><form:radiobutton path="trieuChungHo" value="false"/></td>
                    <td>Tiêu chảy</td>
                    <td><form:radiobutton path="trieuChungTieuChay" value="true"/></td>
                    <td><form:radiobutton path="trieuChungTieuChay" value="false"/></td>
                </tr>
                <tr>
                    <td>Khó thở</td>
                    <td><form:radiobutton path="trieuChungKhoTho" value="true"/></td>
                    <td><form:radiobutton path="trieuChungKhoTho" value="false"/></td>
                    <td>Xuất Huyết Ngoài Da</td>
                    <td><form:radiobutton path="trieuChungXuatHuyet" value="true"/></td>
                    <td><form:radiobutton path="trieuChungXuatHuyet" value="false"/></td>
                </tr>
                <tr>
                    <td>Đau Họng</td>
                    <td><form:radiobutton path="trieuChungDauHong" value="true"/></td>
                    <td><form:radiobutton path="trieuChungDauHong" value="false"/></td>
                    <td>Nỗi Ban Ngoài Da</td>
                    <td><form:radiobutton path="trieuChungNoiBan" value="true"/></td>
                    <td><form:radiobutton path="trieuChungNoiBan" value="false"/></td>
                </tr>
            </table>
        </tr>
        <tr>
            <td>
                <h3>
                    Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có :
                </h3>
            </td>
        </tr>
        <table style="width: 100%">
            <tr>
                <th>

                </th>
                <th style=" text-align: center">
                    Có
                </th>
                <th style="text-align: center">
                    Không
                </th>
            </tr>
            <tr>
                <td>
                    Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật
                </td>
                <td style="text-align: center"><form:radiobutton path="lichSuDenNoiNhiem" value="true"/></td>
                <td style="text-align: center"><form:radiobutton path="lichSuDenNoiNhiem" value="false"/></td>
            </tr>
            <tr>
                <td>
                    Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV
                </td>
                <td style="text-align: center"><form:radiobutton path="lichSuTiepXuc" value="true"/></td>
                <td style="text-align: center"><form:radiobutton path="lichSuTiepXuc" value="false"/></td>
            </tr>
        </table>
        <tr>
            <button type="submit">Gửi tờ khai</button>
        </tr>
    </table>

</form:form>
</body>
</html>