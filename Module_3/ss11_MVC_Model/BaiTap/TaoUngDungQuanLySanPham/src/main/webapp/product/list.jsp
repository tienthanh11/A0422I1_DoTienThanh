<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/20/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        h1 {
            color: red;
            text-align: center;
        }

        p, form {
            text-align: center;
        }

        #view_name {
            text-decoration: none;
            color: darkred;
        }

    </style>
</head>
<body>
<h1>Product Management</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<form>
    <input type="text" name="search" placeholder="Search By Name">
    <input type="text" name="action" hidden value="search">
    <button>Search</button>
</form>
<table class="table table-primary">
    <tr class="table-success text-primary">
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items='${requestScope["products"]}'>
        <tr>
            <td>${product.getId()}</td>
            <td><a id="view_name" href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <a href="/products?action=edit&id=${product.getId()}">
                    <button type="button" class="btn btn-outline-warning">
                        <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
                             width="25" height="25"
                             viewBox="0 0 48 48"
                             style=" fill:#000000;">
                            <path fill="#E57373"
                                  d="M42.583,9.067l-3.651-3.65c-0.555-0.556-1.459-0.556-2.015,0l-1.718,1.72l5.664,5.664l1.72-1.718C43.139,10.526,43.139,9.625,42.583,9.067"></path>
                            <path fill="#FF9800" d="M4.465 21.524H40.471999999999994V29.535H4.465z"
                                  transform="rotate(134.999 22.469 25.53)"></path>
                            <path fill="#B0BEC5" d="M34.61 7.379H38.616V15.392H34.61z"
                                  transform="rotate(-45.02 36.61 11.385)"></path>
                            <path fill="#FFC107" d="M6.905 35.43L5 43 12.571 41.094z"></path>
                            <path fill="#37474F" d="M5.965 39.172L5 43 8.827 42.035z"></path>
                        </svg>
                    </button>
                </a>
            </td>
            <td>
                <a href="/products?action=delete&id=${product.getId()}">
                    <button type="button" class="btn btn-outline-primary">
                        <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
                             width="25" height="25"
                             viewBox="0 0 100 100"
                             style=" fill:#000000;">
                            <path d="M37.297,94.938c-4.641,0-8.578-3.319-9.363-7.894l-8.278-48.311C16.967,37.937,15,35.443,15,32.5 C15,23.402,22.402,16,31.5,16h2.234c2.005-4.158,6.256-7,11.146-7h14.238c4.891,0,9.142,2.842,11.146,7H72.5 C81.598,16,89,23.402,89,32.5c0,2.707-1.664,5.033-4.022,6.009l-8.316,48.533c-0.781,4.573-4.719,7.896-9.362,7.896H37.297z"
                                  opacity=".35"></path>
                            <path fill="#f2f2f2"
                                  d="M35.297,92.938c-4.641,0-8.578-3.319-9.363-7.894l-8.278-48.311C14.967,35.937,13,33.443,13,30.5 C13,21.402,20.402,14,29.5,14h2.234c2.005-4.158,6.256-7,11.146-7h14.238c4.891,0,9.142,2.842,11.146,7H70.5 C79.598,14,87,21.402,87,30.5c0,2.707-1.664,5.033-4.022,6.009l-8.316,48.533c-0.781,4.573-4.719,7.896-9.362,7.896H35.297z"></path>
                            <path fill="#40396e"
                                  d="M63,25H37c-0.828,0-1.5-0.672-1.5-1.5v-4.119c0-4.069,3.312-7.381,7.381-7.381h14.238 c4.069,0,7.381,3.312,7.381,7.381V23.5C64.5,24.328,63.828,25,63,25z M38.5,22h23v-2.619c0-2.416-1.965-4.381-4.381-4.381H42.881 c-2.416,0-4.381,1.965-4.381,4.381V22z"></path>
                            <polygon fill="#9aa2e6"
                                     points="22.806,28.303 32.767,86.438 67.828,86.438 77.79,28.303"></polygon>
                            <path fill="#707cc0"
                                  d="M80.5,28.957h-61v0c0-4.671,3.787-8.457,8.457-8.457h44.085C76.713,20.5,80.5,24.287,80.5,28.957 L80.5,28.957z"></path>
                            <path fill="#40396e"
                                  d="M65.299,87.938H35.297c-2.198,0-4.063-1.572-4.436-3.739L21.917,32H19.5c-0.828,0-1.5-0.672-1.5-1.5 C18,24.159,23.159,19,29.5,19h41C76.841,19,82,24.159,82,30.5c0,0.828-0.672,1.5-1.5,1.5h-1.822l-8.944,52.197 C69.363,86.364,67.498,87.938,65.299,87.938z M21.133,29h2.049c0.73,0,1.355,0.526,1.479,1.247l9.158,53.444 c0.124,0.722,0.746,1.246,1.479,1.246h30.002c0.732,0,1.354-0.524,1.478-1.246l9.158-53.444C76.058,29.526,76.683,29,77.413,29 h1.454c-0.71-3.974-4.192-7-8.367-7h-41C25.325,22,21.843,25.026,21.133,29z"></path>
                            <path fill="#40396e"
                                  d="M38.647,76.944c-0.759,0-1.41-0.574-1.49-1.346l-3.86-37.445c-0.085-0.824,0.515-1.562,1.338-1.646 c0.82-0.08,1.561,0.514,1.646,1.338l3.86,37.445c0.085,0.824-0.515,1.562-1.338,1.646C38.751,76.941,38.699,76.944,38.647,76.944z"></path>
                            <path fill="#40396e"
                                  d="M46.414,76.942c-0.805,0-1.47-0.638-1.498-1.448l-1.298-37.406 c-0.028-0.828,0.619-1.522,1.447-1.551c0.83-0.034,1.521,0.619,1.551,1.447l1.298,37.406c0.028,0.828-0.619,1.522-1.447,1.551 C46.449,76.942,46.432,76.942,46.414,76.942z"></path>
                            <path fill="#40396e"
                                  d="M54.183,76.941c-0.018,0-0.034,0-0.052-0.001c-0.828-0.028-1.477-0.722-1.448-1.55l1.265-37.368 c0.027-0.828,0.746-1.492,1.55-1.448c0.828,0.028,1.477,0.722,1.448,1.55l-1.265,37.368C55.653,76.303,54.987,76.941,54.183,76.941 z"></path>
                            <path fill="#40396e"
                                  d="M61.949,76.939c-0.052,0-0.103-0.003-0.155-0.008c-0.824-0.085-1.424-0.821-1.339-1.646 l3.827-37.328c0.085-0.824,0.818-1.412,1.646-1.339c0.824,0.085,1.424,0.821,1.339,1.646l-3.827,37.328 C63.36,76.364,62.709,76.939,61.949,76.939z"></path>
                        </svg>
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
