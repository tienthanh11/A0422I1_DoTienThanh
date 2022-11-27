<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post" id="formNum">
    <input id="sign" type="hidden" name="sign" value="+"/>
    <input type="text" name="firstNum" value="${firstNum}"/>
    <input type="text" name="secondNum" value="${secondNum}"/>
    <br><br>
    <input type="button" value="Addition(+)" onclick="calculate('+')"/>
    <input type="button" value="Subtraction(-)" onclick="calculate('-')"/>
    <input type="button" value="Multiplication(*)" onclick="calculate('*')"/>
    <input type="button" value="Division(/)" onclick="calculate('/')"/>
</form>
<label>Result: </label><span>${result}</span>
</body>
<script>
    function calculate(sign) {
        document.getElementById("sign").value = sign;
        document.getElementById("formNum").submit();
    }
</script>
</html>
