<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/18/2022
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        h1 {
            color: red;
        }

        #page {
            width: 450px;
            margin: 0 auto;
            padding: 0px 20px 20px;
            background-color: whitesmoke;
            border: 2px solid rebeccapurple;
        }

        label {
            width: 10em;
            padding-right: 1em;
            float: left;
        }

        #content input {
            float: left;
            width: 15em;
            margin-bottom: 5px;
        }

        #color-input {
            color: blue;
            background-color: yellow;
        }
    </style>
</head>
<body>
<div id="page">
    <h1>Product Discount Calculator</h1>
    <form method="post" action="/display-discount">
        <div id="content">
            <label>Product Description</label>
            <input type="text" name="description">
            <br>
            <label>List Price</label>
            <input type="text" name="price">
            <br>
            <label>Discount Percent (%)</label>
            <input type="text" name="discount">
        </div>
        <div>
            <input type="submit" id="color-input" value="Calculate Discount">
        </div>
    </form>
</div>
</body>
</html>
