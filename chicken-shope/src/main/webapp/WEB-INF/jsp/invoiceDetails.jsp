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

</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
	<jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container-fluid pl-5 pr-5">

            <div class="row row-bg user-detail">
                <div class="col-md-8 mx-auto">
                    <div class="p-5 maizil-invoice bg-white shadow-sm">
                        <div class="row mb-1 pb-3 ">
                            <div class="col-md-8 col-10">
                                <h3> Alam Enterprises</h3>
                            </div>
                            <div class="col-md-4 col-2 pl-0 text-right">
                                <p class="mb-4 mt-2">
                                    <a class="text-primary font-weight-bold" href="#"><i class="icofont-print"></i>
                                        PRINT</a>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <p class="mb-1">Ordered from:</p>
                                <h6 class="mb-1 text-black"><strong>${billName}</strong></h6>
                                <p class="mb-1">
                                 ${billAddress}
                                </p>
                            </div>
                            <div class="col-md-4">
                                <p class="mb-1 text-black">Order No: <strong>${productDetailsForSaleList[0].billingNumber}</strong></p>
                                <p class="mb-1">Order placed at: <strong>${orderPlaceDate}</strong></p>
                                <p class="mb-1">
                                    <strong>Phone:</strong> ${phoneNumber}
                                </p>
                                <!-- <p class="mb-1">Order Status: <strong class="text-success">Paid</strong></p> -->
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-12">
                                <table class="table table-bordered mt-3 mb-0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th class="text-black font-weight-bold" scope="col">Sr.</th>
                                            <th class="text-black font-weight-bold" scope="col">Product</th>
                                            <th class="text-black font-weight-bold" scope="col">Quantity</th>
                                            <th class="text-right text-black font-weight-bold" scope="col">Rate</th>
                                            <th class="text-right text-black font-weight-bold" scope="col">Per</th>
                                            <th class="text-right text-black font-weight-bold" scope="col">Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach var="productDetailsForSaleList" varStatus="counter" items="${productDetailsForSaleList}">
                                        <tr>
                                           <td>${counter.count}</td>
			                                <td>${productDetailsForSaleList.productName}</td>
			                                <td>${productDetailsForSaleList.unit}</td>
			                                <td>${productDetailsForSaleList.rate}</td>
			                                <td>${productDetailsForSaleList.perKgOrPiece}</td>
			                                <td class="sumId">${productDetailsForSaleList.sum}</td>
                                        </tr>
                                       </c:forEach>
                                        <tr>
                                            <td class="text-right" colspan="6">
                                                <h6 class="text-right text-dark mb-n1"> Total: &nbsp; &#x20B9;<strong id="totalBillId"></strong></h6>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="amount-in-word">
                                    Amount In Word <br>
                                    <div class="text-dark word-amount"> Nine Thousand Only</div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <p class="text-right">This Is Computer Generated Invoice</p>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12">
                                <div class="company-detail">
                                    <div class="company-name">Alam Enterprises</div>
                                    <div class="company-name1"> Chicken And Mutton Suppliers</div>
                                    <div class="company-heading"> <strong>Phone:</strong> 9898989898 / 7070707070 / 9090909090</div>
                                    <div class="company-heading"> <strong>Fssai:</strong> 000888000999</div>
                                    <div class="company-heading"> <strong>Address:</strong> Shop No.00, Road No.13, Baiganwadi Govandi Mumbai 400043 </div>
                                </div>
                            </div>
                        </div>
                    </div>
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


    <script>
        $(document).ready(function() {
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
        

        
        $(window).on('load', function() {
           // alert("window load occurred!");
            var sum = 0;
            $(".sumId").each(function(){
                sum += +$(this).text();
            });
            $("#totalBillId").text(sum);
            //document.getElementById("demo").innerHTML = "New text"; 
        })
        
        
        
    </script>

</html>