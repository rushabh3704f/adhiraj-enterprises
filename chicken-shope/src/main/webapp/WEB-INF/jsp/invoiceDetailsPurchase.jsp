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
    <link href="./css/pdf.css" rel="stylesheet">

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
                            <div class="col-md-8 col-10 pl-0">
								<div class="c_name h3">
									<h3>${role}</h3>
								</div>
							</div>
							<div class="col-md-4 col-2 pr-0 text-right no-print">
								<p class="mb-4 mt-2">
									<a class="text-primary font-weight-bold print_btn" href="#"><i
										class="icofont-print"></i> PRINT</a>
								</p>
							</div>
                        </div>
                        <div class="row invoice-block">
							<div class="col-md-12 ">
								<div class="h3">Invoice</div>
								<h6 class="mb-2 mt-2 text-black">
									Invoice No: <strong>${productDetailsForPurchaseList[0].billingNumber}</strong>
								</h6>
								<p class="mb-1 text-black">
									Invoice Date: <strong>${orderPlaceDate}</strong>
								</p>
								<p class="mb-3 text-black">
									Phone: <strong>${phoneNumber}</strong> 
								</p>
							</div>
						</div>
						<div class="row mt-5 invoice-to-block">
							<div class="col-md-12">
								<p class="mb-1 text-black"><strong>Invoiced To</strong> </p>
								<h6 class="mb-1 text-black">
									<strong>${billName}</strong>
								</h6>
								<p class="mb-1">${billAddress}</p>
							</div>
						</div>
                        <%-- <div class="row">
                            <div class="col-md-8">
                                <p class="mb-1">Ordered from:</p>
                                <h6 class="mb-1 text-black"><strong>${billName}</strong></h6>
                                <p class="mb-1">
                                  ${billAddress}
                                </p>
                            </div>
                            <div class="col-md-4">
                                <p class="mb-1 text-black">Order No: <strong>${productDetailsForPurchaseList[0].billingNumber}</strong></p>
                                <p class="mb-1">Order placed at: <strong>${orderPlaceDate}</strong></p>
                                <p class="mb-1">
                                    <strong>Phone:</strong> ${phoneNumber}
                                </p>
                            </div>
                        </div> --%>
                        
                        <div class="row pl-0 mb-print">
                            <table class="table table-bordered mt-5 mb-0">
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
                                      <c:forEach var="productDetailsForSaleList" varStatus="counter" items="${productDetailsForPurchaseList}">
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
                        <div class="row">
                            <div class="col-md-6 pl-0">
								<div class="amount-in-word">
										Amount In Word <br>
									<div class="text-dark word-amount" id="amount-in-text" style="text-transform: capitalize;"></div>
								</div>
							</div>
							<div class="col-md-6 pr-0">
									<p class="text-right">This Is Computer Generated Invoice</p>
							</div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-7 pl-0">
                                <div class="company-detail">
                                    <div class="company-name">${role}</div>
                                    <div class="company-name1"> Chicken And Mutton Suppliers</div>
                                    <div class="company-heading"> <strong>Phone:</strong> 9898989898 / 7070707070 / 9090909090</div>
                                    <div class="company-heading"> <strong>Fssai:</strong> 000888000999</div>
                                    <div class="company-heading"> <strong>Address:</strong> Shop No.00, Road No.13, Baiganwadi Govandi Mumbai 400043 </div>
                                </div>
                            </div>
                            <div class="col-md-5 pr-0 my-auto">
								<div class="authorised-sign text-right text-decoration-underline"> 
									Authorized Signature
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
    <script type="text/javascript">
//System for American Numbering 
var th_val = ['', 'thousand', 'million', 'billion', 'trillion'];
// System for uncomment this line for Number of English 
// var th_val = ['','thousand','million', 'milliard','billion'];
 
var dg_val = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
var tn_val = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'];
var tw_val = ['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'];
function toWordsconver(s) {
  s = s.toString();
    s = s.replace(/[\, ]/g, '');
    if (s != parseFloat(s))
        return 'not a number ';
    var x_val = s.indexOf('.');
    if (x_val == -1)
        x_val = s.length;
    if (x_val > 15)
        return 'too big';
    var n_val = s.split('');
    var str_val = '';
    var sk_val = 0;
    for (var i = 0; i < x_val; i++) {
        if ((x_val - i) % 3 == 2) {
            if (n_val[i] == '1') {
                str_val += tn_val[Number(n_val[i + 1])] + ' ';
                i++;
                sk_val = 1;
            } else if (n_val[i] != 0) {
                str_val += tw_val[n_val[i] - 2] + ' ';
                sk_val = 1;
            }
        } else if (n_val[i] != 0) {
            str_val += dg_val[n_val[i]] + ' ';
            if ((x_val - i) % 3 == 0)
                str_val += 'hundred ';
            sk_val = 1;
        }
        if ((x_val - i) % 3 == 1) {
            if (sk_val)
                str_val += th_val[(x_val - i - 1) / 3] + ' ';
            sk_val = 0;
        }
    }
    if (x_val != s.length) {
        var y_val = s.length;
        str_val += 'point ';
        for (var i = x_val + 1; i < y_val; i++)
            str_val += dg_val[n_val[i]] + ' ';
    }
    return str_val.replace(/\s+/g, ' ');
}

	// Calculating Total value
	var sum = 0;
	$(".sumId").each(function() {
		sum += +$(this).text();
	});
	var totalsum = sum; 
	//Converting Number To Text
	var Inwords = toWordsconver(totalsum);
	$("#amount-in-text").text(Inwords+ "Only")
</script>
    
    <!-- Script for print pdf file -->
	<script type="text/javascript">
		$('.print_btn').on('click', function() {
			print();
		})
	</script>

</html>