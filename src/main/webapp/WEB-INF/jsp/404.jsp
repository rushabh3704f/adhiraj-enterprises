<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html><html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Maizil">
    <meta name="author" content="Maizil">
    <title>Reliance Daily Online Food Ordering</title>

    <link rel="icon" type="image/png" href="img/favicon1.png">

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="vendor/fontawesome/css/all.min.css" rel="stylesheet">

    <link href="vendor/icofont/icofont.min.css" rel="stylesheet">

    <link href="vendor/select2/css/select2.min.css" rel="stylesheet">

    <link href="css/maizil.css" rel="stylesheet">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light maizil-nav shadow-sm border-position">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                <!-- <img alt="logo" src="img/favicon.png"> -->
                <img class="logo_size " alt="logo" src="img/Logo/Final logo-02.png">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ml-auto">
                    
                    <li class="nav-item">
                        <a class="nav-link" href="listing.html"><i class="icofont-sale-discount"></i> Offers <span
                                class="badge badge-warning">New</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="404.html"><i class="icofont-live-support"></i> Support</a>
                    </li>
                    
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i> My Account</a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="orders.html#orders"><i class="icofont-food-cart"></i>
                                Orders</a>
                            <a class="dropdown-item" href="orders.html#offers"><i class="icofont-sale-discount"></i>
                                Apply Coupons</a>
                            <a class="dropdown-item" href="orders.html#favourites"><i class="icofont-heart"></i>
                                Favourites</a>
                            <a class="dropdown-item" href="orders.html#payments"><i class="icofont-credit-card"></i>
                                Payments</a>
                            <a class="dropdown-item" href="orders.html#addresses"><i
                                    class="icofont-location-pin"></i> Addresses</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown dropdown-cart">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-shopping-basket"></i> Cart
                            <span class="badge badge-success">4</span>
                        </a>
                        <div class="dropdown-menu dropdown-cart-top p-0 dropdown-menu-right shadow-sm border-0 mt-2">
                            <div class="dropdown-cart-top-header p-4">
                                <img class="img-fluid mr-3" alt="maizil" src="img/cart.jpg">
                                <h6 class="mb-0">Gus's World Famous Chicken</h6>
                                <p class="text-secondary mb-0">Nerul Sec-5,Navi Mumbai,400000 </p>
                                <small><a class="text-primary font-weight-bold" href="detail.html">View Full Menu</a></small>
                            </div>
                            <div class="dropdown-cart-top-body border-top p-4">
                                <p class="mb-2"><i class="icofont-ui-press text-danger food-item"></i> Chicken Tikka
                                     x 1 <span class="float-right text-secondary">&#x20B9; 60</span></p>
                                <p class="mb-2"><i class="icofont-ui-press text-success food-item"></i> Corn & Peas
                                    Salad x 1 <span class="float-right text-secondary">&#x20B9; 50</span></p>
                                <p class="mb-2"><i class="icofont-ui-press text-success food-item"></i> Veg Seekh
                                     x 1 <span class="float-right text-secondary">&#x20B9; 100</span></p>
                                <p class="mb-2"><i class="icofont-ui-press text-danger food-item"></i> Pizza
                                     x 1 <span class="float-right text-secondary">&#x20B9; 300</span></p>
                                
                            </div>
                            <div class="dropdown-cart-top-footer border-top p-4">
                                <p class="mb-0 font-weight-bold text-secondary">Sub Total <span
                                        class="float-right text-dark">&#x20B9; 510</span></p>
                                <small class="text-info">Extra charges may apply</small>
                            </div>
                            <div class="dropdown-cart-top-footer border-top p-2">
                                <a class="btn btn-success btn-block btn-lg" href="checkout.html"> Checkout</a>
                            </div>
                        </div>
                    </li> 
                </ul>
            </div>
        </div>
    </nav>
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center pt-5 pb-5">
                    <img class="img-fluid" src="img/404.png" alt="404">
                    <h1 class="mt-2 mb-2">Restaurant / Dishes not found</h1>
                    <p>Uh-oh! Looks like the page you are trying to access, doesn't <br>exist. Please start afresh.</p>
                    <a class="btn btn-primary btn-lg" href="index.html">GO HOME</a>
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
                    <p><a class="text-info" href="register.html">Register now</a> to get updates on <a
                            href="offers.html">Offers and Coupons</a></p>
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
                        <a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a
                            href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South
                            Indian</a> | <a href="#">Punjabi Food</a> | <a href="#">Fast Food</a> | <a
                            href="#">Chinese</a> | <a href="#">Street Food</a> | <a href="#">Continental</a> | <a
                            href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South Indian</a> | <a
                            href="#">Punjabi Food</a><a href="#">Fast Food</a> | <a href="#">Chinese</a> | <a
                            href="#">Street Food</a> | <a href="#">Continental</a> | <a href="#">Mithai</a> | <a
                            href="#">Cafe</a> | <a href="#">South Indian</a> | <a href="#">Punjabi Food</a> | <a
                            href="#">Fast Food</a> | <a href="#">Chinese</a> | <a href="#">Street Food</a> | <a
                            href="#">Continental</a> | <a href="#">Mithai</a> | <a href="#">Cafe</a> | <a href="#">South
                            Indian</a> | <a href="#">Punjabi Food</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer class="pt-4 pb-4 text-center">
        <div class="container">
            <p class="mt-0 mb-0">© Copyright 2020 maizil Eat. All Rights Reserved</p>
            
        </div>
    </footer>

    <script src="vendor/jquery/jquery-3.3.1.slim.min.js" type="text/javascript"></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    <script src="vendor/select2/js/select2.min.js" type="text/javascript"></script>

    <script src="js/custom.js" type="text/javascript"></script>


</html>