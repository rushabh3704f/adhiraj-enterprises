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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/maizil.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">


</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
	<jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">

            <div class="row mt-5">
                <div class="col-md-4 mb-3 ">
                    <div class="card ibox">
                        <div class="card-header">
                            <span class="income"> Income</span>
                            <span class="float-right income-time mt-1">Monthly</span>
                        </div>
                        <div class="card-body ibox-content">
                            <h1 class="card-title"> <i class="fa fa-inr"></i> 100,000 </h1>
                            <p class="card-text">Totat Income</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card ibox">
                        <div class="card-header">
                            <span class="income"> Orders</span>
                            <span class="float-right income-time mt-1">Anual</span>
                        </div>
                        <div class="card-body ibox-content">
                            <h1 class="card-title"> <i class='fa fa-clipboard'></i> 2570 </h1>
                            <p class="card-text">New Orders</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card ibox">
                        <div class="card-header">
                            <span class="income"> Total Client</span>
                            <span class="float-right income-time mt-1">All Time</span>
                        </div>
                        <div class="card-body ibox-content">
                            <h1 class="card-title"> <i class="fa fa-users"></i> 1270 </h1>
                            <p class="card-text">Active Client</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card ibox">
                        <div class="card-header">
                            <span class="income"> Order Paid </span>
                            <span class="float-right income-time mt-1">All Time</span>
                        </div>
                        <div class="card-body ibox-content">
                            <h1 class="card-title"> <i class="far fa-check-circle"></i> 1270 </h1>
                            <p class="card-text">Total Paid Order </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card ibox">
                        <div class="card-header">
                            <span class="income"> Order Unpaid </span>
                            <span class="float-right income-time mt-1">All Time</span>
                        </div>
                        <div class="card-body ibox-content">
                            <h1 class="card-title"> <i class="fas fa-question-circle"></i> 1270 </h1>
                            <p class="card-text">Total Unpaid Order</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <br><br><br><br>
            </div>
        </div>

    </section>

    <jsp:include page="footer.jsp" />
    </form:form>


    <script src="vendor/jquery/jquery-3.3.1.slim.min.js " type="text/javascript "></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>

    <script src="vendor/select2/js/select2.min.js " type="text/javascript "></script>

    <script src="js/custom.js " type="text/javascript "></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</html>