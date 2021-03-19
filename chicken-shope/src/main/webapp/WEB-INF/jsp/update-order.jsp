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

    <link href="css/maizil.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">
</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-7">
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="client-name" class="col-sm-4 col-form-label">Name:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control-sm" name="client-name" id="client-name">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="contact" class="col-sm-3 col-form-label">Phone:</label>
                                <div class="col-sm-9">
                                    <input type="text" class=" form-control-sm" name="contact" id="contact">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label for="client-address" class="col-sm-2 col-form-label">Address:</label>
                                <div class="col-sm-10">
                                    <input type="text" class=" form-control-sm" name="contact" id="client-address">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-6 mt-2 billing-name-box" style="border-right: 2px solid #fff;">
                            <div class="row mb-n2 mt-2">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <label for="billing-name" class="col-sm-12 text-center col-form-label">Billing Name</label>

                                    </div>
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <input type="text" class="billing-name-txt form-control-sm" name="billing-name" id="billing-name">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mt-2 billing-name-box" style="border-left: 2px solid #fff; border-right: 4px solid #fff;">
                            <div class="row mb-n2 mt-2">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <label for="billing-number" class="col-sm-12 col-form-label">Bill No.: 200012</label>

                                    </div>
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <label>Date  : 05/02/2021 </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- <p class="row mb-3 mt-3"><label for="billing-number" class="">Bill No.: 200012</label></p>
                            <p class="row">
                                <label>Date  : 05/02/2021 </label>
                            </p> -->
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-1 row-bg">
                <div class="col-md-12 mt-3 mb-2">
                    <div class="product-chicken" style="font-size: 18px; font-weight: 600;">
                        Update Order
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="hline"></div>
                </div>
            </div>
            <div class="row mt-1 row-bg">
                <div class="col-md-3 mt-3">
                    <div class="form-group">
                        <label for="product-name">Product Name</label>
                        <input type="text" list="select-product-name" autocomplete="off" class=" form-control form-control-sm " id="product-name " name="product-name " placeholder="Select Product ">
                        <datalist id="select-product-name">
                            <option >Chicken Lollipop</option>
                            <option >Broiler Chicken ( Big ) </option>
                            <option >Broiler Chicken ( Small ) </option>
                            <option >Chicken Tandoori </option>
                            <option >Boneless Brest </option>
                            <option >Chicken Leg </option>
                          </datalist>
                    </div>
                </div>
                <div class="col-md-2 mt-3">
                    <div class="form-group">
                        <label for="product-unit">Unit</label>
                        <input type="text" autocomplete="off" class=" form-control form-control-sm " id="product-unit " name="product-unit " placeholder="Product Unit ">
                    </div>
                </div>
                <div class="col-md-2 mt-3">
                    <div class="form-group">
                        <label for="product-per">Per</label>
                        <input type="text" autocomplete="off" class=" form-control form-control-sm " id="product-per " name="product-per" placeholder=" Per Kg/Pice">
                    </div>
                </div>
                <div class="col-md-3 mt-3">
                    <div class="form-group">
                        <label for="product-rate">Rate</label>
                        <input type="text" autocomplete="off" class=" form-control form-control-sm " id="product-rate " name="product-rate" placeholder="Product Rate ">
                    </div>
                </div>
                <div class="col-md-2 mt-5">
                    <div class="form-group">
                        <button class="btn btn-success w-100">Update Item To List</button>
                    </div>
                </div>
                <div class="col-md-12 ">
                    <div class="hline "></div>
                </div>
                <div class="col-md-12 add-product-to-list-table">
                    <table class="table table-bordered mt-3 mb-0">
                        <thead class="thead-light">
                            <tr>
                                <th class="text-black font-weight-bold" scope="col">Sr.</th>
                                <th class="text-black font-weight-bold" scope="col">Product</th>
                                <th class="text-black font-weight-bold" scope="col">Quantity</th>
                                <th class="text-left text-black font-weight-bold" scope="col">Rate</th>
                                <th class="text-left text-black font-weight-bold" scope="col">Per</th>
                                <th class="text-left text-black font-weight-bold" scope="col">Amount</th>
                                <th class="text-left text-black font-weight-bold" scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>01</td>
                                <td>Broiler Chicken ( Big )</td>
                                <td>10</td>
                                <td class="text-left">100</td>
                                <td class="text-left">kg</td>
                                <td class="text-left">&#x20B9; 1000</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>02</td>
                                <td>Chicken Lollipop</td>
                                <td>10</td>
                                <td class="text-left">150</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 1500</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>03</td>
                                <td>Chicken Keema</td>
                                <td>12</td>
                                <td class="text-left">100</td>
                                <td class="text-left">Pice</td>
                                <td class="text-left">&#x20B9; 1200</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>04</td>
                                <td>Chicken Leg</td>
                                <td>20</td>
                                <td class="text-left">30</td>
                                <td class="text-left">Pice</td>
                                <td class="text-left">&#x20B9; 600</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>05</td>
                                <td>Chicken Petha</td>
                                <td>10</td>
                                <td class="text-left">80</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 800</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>06</td>
                                <td>Chicken Petha</td>
                                <td>10</td>
                                <td class="text-left">80</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 800</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>07</td>
                                <td>Chicken Petha</td>
                                <td>10</td>
                                <td class="text-left">80</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 800</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>08</td>
                                <td>Chicken Liver</td>
                                <td>10</td>
                                <td class="text-left">70</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 700</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>09</td>
                                <td>Chicken Wing</td>
                                <td>10</td>
                                <td class="text-left">80</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 800</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td>Chicken Tandoori</td>
                                <td>10</td>
                                <td class="text-left">80</td>
                                <td class="text-left">Kg</td>
                                <td class="text-left">&#x20B9; 800</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm">Remove</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-right" colspan="7">
                                    <h6 class="text-right text-dark mb-n1"> Total: &nbsp; &#x20B9; 9000</h6>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row row-bg ">
                <div class="col-md-8 mt-2"></div>
                <div class="col-md-4 mt-2">
                    <div class="form-group row ">
                        <label for="bill-amount " class="col-sm-6 col-form-label "><strong>Bill Amount:</strong></label>
                        <div class="col-sm-6 ">
                            <input type="text " class="form-control-sm " name="bill-amount " id="bill-amount ">
                        </div>
                    </div>
                    <div class="form-group row ">
                        <label for="bill-amount " class="col-sm-6 col-form-label "><strong>Paid Amount:</strong></label>
                        <div class="col-sm-6 ">
                            <input type="text " class="form-control-sm " name="paid-amount " id="paid-amount ">
                        </div>
                    </div>
                    <button class="btn btn-success ">Update Order</button>
                </div>
                <div class="col-md-12">
                    <br>
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


</html>