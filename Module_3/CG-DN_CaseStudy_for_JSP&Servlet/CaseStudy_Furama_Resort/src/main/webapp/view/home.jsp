<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/3/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="template/datatable/css/dataTables.bootstrap4.css">
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
            <form class="d-flex m-0">
                <input type="search" class="form-control me-2" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-warning text-primary" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>

<!-- slide -->
<div>
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="template/image/card/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                     class="d-block w-100" alt="..." height="500px">
            </div>
            <div class="carousel-item">
                <img src="template/image/card/Vietnam_Danang_Furama_Resort_Exterior_Courtyard.jpg" class="d-block w-100"
                     alt="..." height="500px">
            </div>
            <div class="carousel-item">
                <img src="template/image/card/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                     class="d-block w-100"
                     alt="..." height="500px">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<br>

<div class="container mt-3 mb-0">
    <div class="row">
        <div class="col-md-4 m-0">
            <h2 class="font-text-footer" style="font-size: 24px">
                THE WORLD-CLASS RESORT,<br>
                FURAMA DANANG, <br>
                IS FAMOUS AS A FOOD RESORT IN VIETNAM.</h2>
        </div>
        <div class="col-md-4 m-0">
            <iframe src="https://www.youtube.com/embed/IjlT_4mvd-c" title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen style="height: 300px; width: 400px"></iframe>
        </div>
        <div class="col-md-4 m-0">
            <p class="font-text">
                Facing the white sandy beach of Da Nang, Furama Resort Danang is the gateway to 3 world cultural
                heritages: Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours, 196 rooms. Villas from two to four
                bedrooms with private pools are tastefully decorated, in traditional Vietnamese design style and French
                colonial architecture, making Furama a prestigious resort in Vietnam - honor attended to welcome many
                celebrities, royalty, politicians, movie stars and international business leaders.
            </p>
        </div>
    </div>
</div>

<br><br>

<!-- sidebar -->
<div>
    <div class="row m-0">
        <div class="col-md-2 p-0">
            <div class="card">
                <img src="template/image/card/side-bar.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="font-text-footer card-text">CULINARY</p>
                    <p class="font-text card-text">
                        The resort’s culinary experience features a mixture of the authentic and locally inspired
                        Vietnamese, Asian, Italian and other European cuisines plus the best imported steaks. The resort
                        presents guests with varied gastronomic venues – the hip and breezy bar overlooking the beach,
                        the exclusive Lagoon pool surrounded by a tropical garden, the true Italian flare offered at
                        the Don Cipriani’s, the refined Asian touch at Café Indochine or the authentic central Vietnam
                        cuisine at the Danaksara.
                    </p>
                </div>
            </div>
            <div class="card">
                <img src="template/image/card/side-bar-2.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="font-text-footer card-text">MEETING and EVENT</p>
                    <p class="font-text card-text">
                        A well-appointed International Convention Palace with ballrooms can accommodate up to
                        1,000 people in style, with another ten function rooms for 50 to 300 people each.
                        A variety of cultural-themed parties on the beach or around the lagoon, in the ballrooms
                        or outside the resort, with the surprising arrivals of VIPs from Helicopter landing on the
                        resort’s own Helipad…
                    </p>
                </div>
            </div>
        </div>

        <!-- content -->
        <div class="col-md-10 p-0">
            <img src="template/image/Furama-resort-danang-103-105-vo-nguyen-giap-da-nang-fly-cam.jpg" height="100%"
                 width="100%">
        </div>
    </div>
</div>

<br><br><br>

<%-- footer --%>
<div class="position-relative mx-0 bottom-0 row" style="background-color: aquamarine; width: 100%">
    <div class="col-md-1"></div>
    <div class="col-md-3 bg-light container">
        <h2 class="font-text-footer">Moving Guide</h2>
        <p class="font-text">Furama is a premier base for exploring one of Asia’s most exciting new destinations.
            Just a short drive from Danang lay four UNESCO-listed World Heritage Sites:</p>
        <button class="btn btn-outline-light bg-success">
            <span>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                </svg>
            </span>
            <span>View on Map</span>
        </button>
        <h4 class="font-text-footer mt-3">Local Places</h4>
        <div class="row">
            <div class="col-md-8 text-primary">
                <h6> 1. The former imperial city of HUE </h6>
                <h6> 2. The ancient Hoi An </h6>
                <h6> 3. Champa civilization, My Son </h6>
                <h6> 4. Phong Nha Caves </h6>
            </div>
            <div class="col-md-4">
                <p style="color: darkgrey">2 hours</p>
                <p style="color: darkgrey">30 minutes</p>
                <p style="color: darkgrey">90 minutes</p>
                <p style="color: darkgrey">3 hours</p>
            </div>
        </div>
    </div>

    <div class="col-md-4 d-flex justify-content-center align-content-center text-primary">
        <ul>
            <li class="my-5">News</li>
            <li class="my-5">Rack Rate</li>
            <li class="my-5">Lifestyle Blog</li>
            <li class="my-5">Work with us</li>
            <li class="my-5">Contract us</li>
        </ul>
    </div>
    <div class="col-md-3 mt-5">
        <h2 class="font-text-footer">Contract US</h2>
        <br>
        <div class="row">
            <div class="col-md-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                </svg>
            </div>
            <div class="col-md-10">
                <p style="font-size: 14px">
                    103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam
                </p>
                <p style="font-size: 14px">Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</p>
                <p style="font-size: 14px">Email: reservation@furamavietnam.com</p>
                <p style="font-size: 14px">
                    www.furamavietnam.com GDS Codes: Amadeus-GD DADFUR,
                    Galileo/Apollo-GD 16236, Sabre-GD 032771, Worldspan- GD DADFU
                </p>
                <hr>
                <a href="https://www.facebook.com/furamaresort/" target="_blank" rel="noopener">
                    <img style="width: 32px;height: 32px;float: left"
                         src="https://furamavietnam.com/wp-content/uploads/2019/06/incon-Facbook-1.png" alt="" width="32"
                         height="32"/>
                </a>
                <a href="https://www.instagram.com/furama_resort_danang/?hl=vi" target="_blank" rel="noopener">
                    <img style="width: 40px;height: 32px;float: left"
                         src="https://furamavietnam.com/wp-content/uploads/2019/06/social-ins.png" alt="" width="40"
                         height="32"/>
                </a>
                <a href ="https://www.youtube.com/user/furamaresortvietnam/featured" target="_blank" rel="noopener">
                    <img style="width: 40px;height: 32px;float: left"
                         src="https://furamavietnam.com/wp-content/uploads/2021/10/social-youtube.png" alt="" width="40"
                         height="32"/>
                </a>
                <br><br><br>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>

</body>
<script src="template/bootstrap/jquery-3.6.0.min.js"></script>
<script src="template/bootstrap/js/bootstrap.js"></script>
<script src="template/datatable/js/jquery.dataTables.min.js"></script>
<script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
<script src="template/main.js"></script>
</html>
