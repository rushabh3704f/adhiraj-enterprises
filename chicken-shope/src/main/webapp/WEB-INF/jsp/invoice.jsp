<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">


<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Maizil">
    <meta name="author" content="Maizil">
    <title>Aalm Enterprises</title>

    <link rel="icon" type="image/png" href="img/favicon1.png">

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="vendor/fontawesome/css/all.min.css" rel="stylesheet">

    <link href="vendor/icofont/icofont.min.css" rel="stylesheet">

    <link href="vendor/select2/css/select2.min.css" rel="stylesheet">

    <link href="css/maizil.css" rel="stylesheet">
</head>

<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
	<jsp:include page="header.jsp" />
    <section class="breadcrumb-maizil pt-5 pb-5 bg-dark position-relative text-center invoice-mt">
        <h1 class="text-white">Invoice</h1>
        <h6 class="text-white-50">Order #25102589748</h6>
    </section>
    <section class="section pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div class="p-5 maizil-invoice bg-white shadow-sm">
                        <div class="row mb-5 pb-3 ">
                            <div class="col-md-8 col-10">
                                <h3 class="mt-0">Thanks for choosing <strong class="text-secondary">Reliance Daily</strong>, Akram ! Here are your order details: </h3>
                            </div>
                            <div class="col-md-4 col-2 pl-0 text-right">
                                <p class="mb-4 mt-2">
                                    <a class="text-primary font-weight-bold" href="#"><i class="icofont-print"></i>
                                        PRINT</a>
                                </p>
                                <img class="invoice-logo" style="height: 50px; width:auto;" alt="logo" src="img/Logo/Final logo-02.png">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <p class="mb-1 text-black">Order No: <strong>#25102589748</strong></p>
                                <p class="mb-1">Order placed at: <strong>12/11/2018, 06:26 PM</strong></p>
                                <p class="mb-1">Order delivered at: <strong>12/11/2018, 07:18 PM</strong></p>
                                <p class="mb-1">Order Status: <strong class="text-success">Delivered</strong></p>
                            </div>
                            <div class="col-md-6">
                                <p class="mb-1 text-black">Delivery To:</p>
                                <p class="mb-1 text-primary"><strong>Akram Khan</strong></p>
                                <p class="mb-1">291/d/1, 291, Jawaddi Kalan, Ludhiana, Punjab 141002, India
                                </p>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col-md-12">
                                <p class="mb-1">Ordered from:</p>
                                <h6 class="mb-1 text-black"><strong>Shahi Khansama</strong></h6>
                                <p class="mb-1">Shop 3, Model Town Extension, Model Town, Ludhiana</p>
                                <table class="table mt-3 mb-0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th class="text-black font-weight-bold" scope="col">Item Name</th>
                                            <th class="text-right text-black font-weight-bold" scope="col">Quantity</th>
                                            <th class="text-right text-black font-weight-bold" scope="col">Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Veg Masala Roll</td>
                                            <td class="text-right">01</td>
                                            <td class="text-right">&#x20B9; 49</td>
                                        </tr>
                                        <tr>
                                            <td>Veg Burger</td>
                                            <td class="text-right">01</td>
                                            <td class="text-right"> &#x20B9; 45</td>
                                        </tr>
                                        <tr>
                                            <td>Veg Penne Pasta in Red Sauce</td>
                                            <td class="text-right">01</td>
                                            <td class="text-right">&#x20B9; 135</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right" colspan="2">Item Total:</td>
                                            <td class="text-right"> &#x20B9; 229</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right" colspan="2">GST:</td>
                                            <td class="text-right"> &#x20B9; 9.6</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right" colspan="2">Delivery Charges:</td>
                                            <td class="text-right"> &#x20B9; 00</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right" colspan="2">Discount Applied (First50):</td>
                                            <td class="text-right"> &#x20B9; 50</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right" colspan="2">
                                                <h6 class="text-success">Grand Total:</h6>
                                            </td>
                                            <td class="text-right">
                                                <h6 class="text-success"> &#x20B9; 188.6</h6>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section pt-5 pb-5 text-center bg-white">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h5 class="m-0">Operate food store or restaurants? <a href="login.html">Work With Us</a></h5>
                </div>
            </div>
        </div>
    </section>
    <section class="footer pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-12 col-sm-12">
                    <h6 class="mb-3">Subscribe to our Newsletter</h6>
                    <form class="newsletter-form mb-1">
                        <div class="input-group">
                            <input type="text" placeholder="Please enter your email" class="form-control">
                            <div class="input-group-append">
                                <button type="button" class="btn btn-primary">
                                    Subscribe
                                </button>
                            </div>
                        </div>
                    </form>
                    <p><a class="text-info" href="register.html">Register now</a> to get updates on <a href="offers.html">Offers and Coupons</a></p>
                    <div class="app">
                        <p class="mb-2">DOWNLOAD APP</p>
                        <a href="#">
                            <img class="img-fluid" src="img/google.png">
                        </a>
                        <a href="#">
                            <img class="img-fluid" src="img/apple.png">
                        </a>
                    </div>
                </div>
                <div class="col-md-1 col-sm-6 mobile-none">
                </div>
                <div class="col-md-2 col-4 col-sm-4">
                    <h6 class="mb-3">About OE</h6>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Culture</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Careers</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-4 col-sm-4">
                    <h6 class="mb-3">For Foodies</h6>
                    <ul>
                        <li><a href="#">Community</a></li>
                        <li><a href="#">Developers</a></li>
                        <li><a href="#">Blogger Help</a></li>
                        <li><a href="#">Verified Users</a></li>
                        <li><a href="#">Code of Conduct</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-4 col-sm-4">
                    <h6 class="mb-3">For Restaurants</h6>
                    <ul>
                        <li><a href="#">Advertise</a></li>
                        <li><a href="#">Add a Restaurant</a></li>
                        <li><a href="#">Claim your Listing</a></li>
                        <li><a href="#">For Businesses</a></li>
                        <li><a href="#">Owner Guidelines</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <section class="footer-bottom-search pt-5 pb-5 bg-white">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">

                    <p class="mt-4 text-black">POPULAR FOOD</p>
                    <div class="search-links">
                        <a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South
                            Indian</a> | <a href="#">Punjabi Food</a> | <a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South Indian</a>                        | <a href="#">Punjabi Food</a><a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South Indian</a> | <a href="#">Punjabi Food</a>                        | <a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South
                            Indian</a> | <a href="#">Punjabi Food</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="footer.jsp" />
    </form:form>


    <script src="vendor/jquery/jquery-3.3.1.slim.min.js" type="8337e13da3b2950c987ce10b-text/javascript"></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="8337e13da3b2950c987ce10b-text/javascript"></script>

    <script src="vendor/select2/js/select2.min.js" type="8337e13da3b2950c987ce10b-text/javascript"></script>

    <script src="js/custom.js" type="8337e13da3b2950c987ce10b-text/javascript"></script>
</body>


</html>