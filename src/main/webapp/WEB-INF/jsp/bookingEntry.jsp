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
    <title>Adhiraj Enterprises</title>
    <link rel="icon" type="image/png" href="img/favicon1.png">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/fontawesome/css/all.min.css" rel="stylesheet">
    <link href="vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="vendor/select2/css/select2.min.css" rel="stylesheet">
    <link href="css/maizil.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<spring:url value="/fetchBookingDetails" var="url"></spring:url>
    <form:form name="allocationDetailsModel" id="allocationDetailsModel" commoandName="allocationDetailsModel" modelAttribute="allocationDetailsModel" action="${url}" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-12 col-12">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Booking Entry
                        </div>
                        <i class="fa fa-home"></i>/ <b>Booking Entry</b>
                    </div>
                </div>
            </div>
            
              <div class="row mt-2 row-bg">
                <div class="col-md-3 mt-2">
                  <div class="mb-3">
						<label for="formFile" class="form-label">Enter Chassis Number</label> 
						<form:input path="searchChassisNum" type="text" autocomplete="off" class="form-control" id="searchChassisNumId"  name="searchChassisNum" placeholder="Chassis Number"/>
					</div>
                </div>
                
                <div class="col-md-3 mt-2">	
                 <div class="mb-3">
						<label for="formFile" class="form-label"><br> </label> 
                        <button type="submit" class="btn btn-success form-control">Search</button>
					</div>										
                 </div>
                 
                  <div class="col-md-3 mt-2">	
                 <div class="mb-4">
						<label for="formFile" class="form-label"><br> <br> ${message}</label> 
					</div>										
                 </div>                
                 <div class="col-md-12">
                    <br>
                </div>
            </div>
            
            
            <!-- --------------New Row--------------------------------------- -->
            <div class="row mt-1 row-bg">
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">Delivery Number</label>
                        <form:input path="deliveryNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Delivery Number"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Chassis Number</label>
                        <form:input path="vehicleChassisNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Chassis Number"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Last Six Digit</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="Last Six Digit"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Model Code</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Model Code"/>
                    </div>
                </div>
                
                 <!-- --------------New Row--------------------------------------- -->
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">Model Description</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Model Description"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Depo/Dealer</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Depo/Dealer"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">STN Date</label>
                        <form:input path="trcNo" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="STN Date"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">TC/TRC/No</label>
                        <form:input path="trcNo" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="TC/TRC/No"/>
                    </div>
                </div>
                
                 <!-- --------------New Row--------------------------------------- -->
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">Destination</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Destination"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">From</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="From"/>
                    </div>
                </div>

				<div class="col-md-3 mt-2">
					<div class="form-group"></div>
				</div>
				
					<div class="col-md-3 mt-2">
					<div class="form-group"></div>
				</div>

					<div class="col-md-12 ">
						<div class="hline "></div>
					</div>
					
					<div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Select Destination</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="Select Destination"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Select Model</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Select Model"/>
                    </div>
                </div>
                
               <!-- --------------New Row--------------------------------------- -->
               <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">AVG</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm  clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="AVG"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Select Driver</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Select Driver"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">KM</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="KM"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Total Diesel</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Total Diesel"/>
                    </div>
                </div>
                
               <!-- --------------New Row--------------------------------------- -->
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Diesel Price</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Diesel Price"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Diesel Amount</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="productUnitId" onkeyup="totalSum();" name="Diesel Amount" placeholder="Product Unit"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Pump Diesel</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Pump Diesel"/>
                    </div>
                </div>
                
               <!-- --------------New Row--------------------------------------- -->
               <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">Hand Diesel</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Hand Diesel"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Driver wages</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm auto-val clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Driver wages"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Other Amount</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="Other Amount"/>
                    </div>
                </div>
                <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Return Face</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Return Face"/>
                    </div>
                </div>
               <div class="col-md-3 mt-2">
                    <div class="form-group">
                        <label for="product-name">Total</label>
                        <form:input path="stockTrNum" type="text" autocomplete="off" class="form-control-sm clearData" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Total"/>
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                 
                <div class="col-md-12 ">
                    <div class="hline "></div>
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
    <script src="vendor/jquery/customJquery.js" type="text/javascript"> </script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>
    <script src="vendor/select2/js/select2.min.js " type="text/javascript "></script>
    <script src="js/custom.js " type="text/javascript "></script>
    <script type="text/javascript">
    
    function getDropdownId(elem) {
    	  var productId=elem.value;
    		   $.ajax({
    		        url : '${BASE_URL}/getDropdownValue?productId='+ productId,
    		        type : 'post',
    		        success : function(data) {
      		          $("#perKgOrPiceId").val(data.unitType);
					  $("#productUnitId").val(data.unit);
					  $("#productRateId").val(data.rate);
					  $("#sumId").val(parseFloat(data.unit)*parseFloat(data.rate));
    		        },
    		        error:function(error){
    		        	alert(data);
    		        }
    		    });  		    
    		}
    
    $("#billingName").change(function () {
        var end = this.value;
        $.ajax({
	        url : '${BASE_URL}/getDropdownValue?productId='+ productId,
	        type : 'post',
	        success : function(data) {
			  $("#productUnitId").val(data.unit);
			  $("#productRateId").val(data.rate);
			  $("#sumId").val(parseFloat(data.unit)*parseFloat(data.rate));
			  
	        },
	        error:function(error){
	        	alert(data);
	        }
	    });  
    });
    
    
    
    
    function totalSum() {
	      var txtFirstNumberValue = parseFloat($("#productUnitId").val());
	      var txtSecondNumberValue = parseFloat($("#productRateId").val());
	      if(isNaN(txtFirstNumberValue)){
	    	  txtFirstNumberValue=0;
	      }
	      if(isNaN(txtSecondNumberValue)){
	    	  txtSecondNumberValue=0;
	      }
	      var result = parseFloat(txtFirstNumberValue) * parseFloat(txtSecondNumberValue);
	      if (!isNaN(result)) {
	         $("#sumId").val(result);
	      }
	}
   

	function validateForm() {
		var billingName = document.forms["shopeCreateOrderForSale"]["billingName"].value;
		var phoneNumber = document.forms["shopeCreateOrderForSale"]["phoneNumber"].value;
		var addressError = document.forms["shopeCreateOrderForSale"]["address"].value;
		var clientNameError = document.forms["shopeCreateOrderForSale"]["clientName"].value;

		if (billingName == "") {
			alert("Please Select Billing Name.");
			document.getElementById("billingNameError").innerHTML = "Please Select Billing Name.";
			return false;
		}
		if (phoneNumber == "") {
			alert("Please Enter Phone Number.");
			document.getElementById("phoneNumberError").innerHTML = "Please Enter Phone Number.";
			return false;
		}
		if (addressError == "") {
			alert("Please Enter Address.");
			document.getElementById("addressError").innerHTML = "Please Enter Address.";
			return false;
		}
		if (clientNameError == "") {
			alert("Please Enter Client Name .");
			document.getElementById("clientNameError").innerHTML = "Please Enter client Name.";
			return false;
		}
		if (productError == "") {
			alert("Please Select Product ");
			document.getElementById("productError").innerHTML = "Please Select Product.";
			return false;
		}
		document.shopeCreateOrderForSale.command.value='generateBill';
		return true;
	}

	
	function validateDropdown() {

		var billingName = document.forms["shopeCreateOrderForSale"]["billingName"].value;
		var phoneNumber = document.forms["shopeCreateOrderForSale"]["phoneNumber"].value;
		var addressError = document.forms["shopeCreateOrderForSale"]["address"].value;
		var clientNameError = document.forms["shopeCreateOrderForSale"]["clientName"].value;

		if (billingName == "") {
			alert("Please Select Billing Name.");
			document.getElementById("billingNameError").innerHTML = "Please Select Billing Name.";
			return false;
		}
		if (phoneNumber == "") {
			alert("Please Enter Phone Number.");
			document.getElementById("phoneNumberError").innerHTML = "Please Enter Phone Number.";
			return false;
		}
		if (addressError == "") {
			alert("Please Enter Address.");
			document.getElementById("addressError").innerHTML = "Please Enter Address.";
			return false;
		}
		if (clientNameError == "") {
			alert("Please Enter Client Name .");
			document.getElementById("clientNameError").innerHTML = "Please Enter client Name.";
			return false;
		}
		if (productError == "") {
			alert("Please Select Product ");
			document.getElementById("productError").innerHTML = "Please Select Product.";
			return false;
		}

		var productError = document.forms["shopeCreateOrderForSale"]["product"].value;
		if (productError == "") {
			alert("Please Select Product ");
			document.getElementById("productError").innerHTML = "Please Select Product.";
			return false;
		}
		document.shopeCreateOrderForSale.command.value = 'addItemInList';
		return true;
	}
	
	$(function() {
		  $('#billingNameId').on('input',function() {
		    var opt = $('option[value="'+$(this).val()+'"]');
		    //alert(opt.length ? opt.attr('id') : 'NO OPTION');
		    if(opt.length > 0){
		    	var billingNameId=opt.attr('id');
		    	//alert(billingNameId);
		    	//--------------------
		    	   $.ajax({
		   	        url : '${BASE_URL}/getBillingDetails?billingNameId='+ billingNameId,
		   	        type : 'post',
		   	        success : function(data) {
		   	        	
	    		      $("#perKgOrPiceId").val(data.unitType);
		   			  $("#phoneNumberId").val(data.phoneNumber);
		   			  $("#clientAddressId").val(data.address);
		   			  $("#clientNameId").val(data.clientName);
		   	        },
		   	        error:function(error){
		   	        	alert(data);
		   	        }
		   	    }); ///Ajax end
		    	
		    }//if body end
		    
		  });
	 });//function end
	 
	 
	 function submitFormByAction(formId,actionURL)
	 {
	     document.getElementById(formId).action = actionURL;
	     document.getElementById(formId).method = "post";
	     document.getElementById(formId).submit();
	 }
	 
	
	    function paidAmountFun() {
		      var txtFirstNumberValue = parseFloat($("#billAmountId").val());
		      var txtSecondNumberValue = parseFloat($("#paidAmountId").val());
		      
		      if(isNaN(txtFirstNumberValue)){
		    	  txtFirstNumberValue=0;
		      }
		      if(isNaN(txtSecondNumberValue)){
		    	  txtSecondNumberValue=0;
		      }
		      var result = parseFloat(txtFirstNumberValue) - parseFloat(txtSecondNumberValue);
		      if (!isNaN(result)) {
		         $("#unPaidAmountId").val(result);
		      }
		}
	    
	    $( document ).ready(function() {
	    	 $(".clearData").each(function() {
	    		   $(this).val('');
	    	      });
	    });
	 
	
</script>
    
    
           
                                                      


</html>