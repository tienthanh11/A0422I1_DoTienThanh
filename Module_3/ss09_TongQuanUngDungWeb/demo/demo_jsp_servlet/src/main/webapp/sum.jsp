<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/18/2022
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    int s = n1+n2;
%>
<h1> trang sum jsp : kết quả : <%=s%></h1>
</body>
</html>
