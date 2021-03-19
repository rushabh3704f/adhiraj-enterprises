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

    <link href="vendor/select2/css/select2.min.css" rel="stylesheet">
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
                <div class="col-md-6 col-6">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Purchase Order List By Bill Number
                        </div>
                        <i class="fa fa-home"></i>/ Purchase / <b>Purchase Order List</b>
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <a href="purchase-order.html" class="btn btn-success btn-sm">New Order</a>
                    </div>
                </div>
            </div>
            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Billing Number</th>
                                <th>Product Name</th>
                                <th>Unit</th>
                                <th>Rate</th>
                                <th>Sum</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="productDetailsForSaleList" varStatus="counter" items="${productDetailsForSaleList}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${productDetailsForSaleList.billingNumber}</td>
                                <td>${productDetailsForSaleList.productName}</td>
                                <td>${productDetailsForSaleList.unit}</td>
                                <td>${productDetailsForSaleList.rate}</td>
                                 <td>${productDetailsForSaleList.sum}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <a href="view-purchase-order.html" class="btn btn-dark btn-sm">Delete</a>
                                        &nbsp;<a href="view-purchase-order.html" class="btn btn-dark btn-sm">Update</a>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                    </table>
                </div>
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