<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html><html lang="en">

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

    <!-- <link href="vendor/select2/css/select2.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/maizil.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">

    <!-- Data Table CDN -->
    <link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
	<jsp:include page="header.jsp" />
   
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container-fluid pl-5 pr-5">
            <div class="row row-bg user-detail">
                <div class="col-md-12 col-12">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Sales Report
                        </div>
                        <i class="fa fa-home"></i>/ My Account / <b>Sales Report</b>
                    </div>
                </div>
            </div>
            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3">
                    <h6>Filter </h6>
                </div>
                <div class="col-md-2">
                    <div class="filter-box mt-3">
                        <input class="form-control form-control-sm" id="name-filter" name="name-filter" type="text" placeholder="Client Name">
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="filter-box mt-3">
                        <input class="form-control form-control-sm" id="id-filter" name="id-filter" type="text" placeholder="Order ID">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="filter-box mt-3">
                        <select id="payment-status-filter" name="payment-status-filter" class="form-control form-control-sm">
                            <option> ---Select Payment Status--- </option>
                            <option> Paid </option>
                            <option> Unpaid </option>
                        </select>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="filter-box mt-3">
                        <div class="input-group input-group-sm mb-3">
                            <input type="date" class="form-control form-control-sm" id="date-from" name="date-from" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-sm">To</span>
                            </div>
                            <input type="date" class="form-control form-control-sm" id="date-to" name="date-to" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
                        </div>
                    </div>
                </div>
                <div class="col-md-12 mt-3" style="overflow: scroll;">
                    <table id="example" class="table table-striped table-bordered" style="width:100%; ">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Order ID</th>
                                <th>Name</th>
                                <th>Billing_Name</th>
                                <th>Date</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Broiler Chicken ( Big )</th>
                                <th>Broiler Chicken ( Small )</th>
                                <th>Chicken Tandoori</th>
                                <th>Boneless Brest</th>
                                <th>Boneless Leg</th>
                                <th>Chicken Leg</th>
                                <th>Chicken Drumsticks</th>
                                <th>Chicken Wing</th>
                                <th>Chicken Lollipop</th>
                                <th>Chicken Keema</th>
                                <th>Chicken Liver</th>
                                <th>Chicken Petha</th>
                                <th>Chicken Carpas</th>
                                <th>Chicken Paya</th>
                                <th>Mutton Leg ( Big )</th>
                                <th>Mutton Leg ( Small )</th>
                                <th>Mutton Boneless</th>
                                <th>Mutton Keema</th>
                                <th>Mutton Liver</th>
                                <th>Mutton Paya</th>
                                <th>English Egg</th>
                                <th>Total Amount</th>
                                <th>Payment</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>#20001</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>12/12/2021</td>
                                <td>9898989898</td>
                                <td>Mumbai Maharashtra</td>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <td> 10000</td>
                                <td> 10000</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <a href="#" class="btn btn-primary btn-sm">Download</a>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>#20001</td>
                                <td>Mary</td>
                                <td>Doe</td>
                                <td>12/12/2021</td>
                                <td>9898989898</td>
                                <td>Mumbai Maharashtra</td>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <th>15</th>
                                <th>10</th>
                                <th>15</th>
                                <td> 10000</td>
                                <td> 10000</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <a href="#" class="btn btn-primary btn-sm">Download</a>
                                    </div>
                                </td>
                            </tr>

                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>
            </div>
        </div>

    </section>

    <jsp:include page="footer.jsp" />
    </form:form>


    <script src="vendor/jquery/jquery-3.3.1.slim.min.js " type="text/javascript "></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>

    <!-- <script src="vendor/select2/js/select2.min.js " type="text/javascript "></script> -->

    <script src="js/custom.js " type="text/javascript "></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Data Table Js -->
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>

    <script>
        // Data Table Function
        $(document).ready(function() {
            $('#example').dataTable({
                aaSorting: [
                    [0, 'asc']
                ]
            })
        });
    </script>


</html>