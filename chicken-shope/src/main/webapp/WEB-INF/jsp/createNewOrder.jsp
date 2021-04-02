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
    <link href="css/common.css" rel="stylesheet">
</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<spring:url value="/createNewOrder" var="url"></spring:url>
    <form:form name="shopeCreateOrderForSale" id="shopeCreateOrderForSale" commoandName="shopeCreateOrderForSale" modelAttribute="shopeCreateOrderForSale" action="${url}" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-12 col-12">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            New Order
                        </div>
                        <i class="fa fa-home"></i>/ <b>New Order</b>
                    </div>
                </div>
            </div>
            
            <div class="row row-bg user-detail mt-1">
                <div class="col-md-7">
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="billing-name" class="col-sm-4 col-form-label pr-0"> Billing Name:</label>
                                <div class="col-sm-8">
                                <form:input path="billingName" list="billingName" id="billingNameId" name="billingNameId" autocomplete="off" class=" form-control-sm"/>
								  <datalist id="billingName">
								     <c:forEach var="shopeCreateClient" varStatus="counter" items="${shopeCreateClientList}">	
								     <option id="${shopeCreateClient.clientId}" value="${shopeCreateClient.billingName}"/>
								     </c:forEach>
								 </datalist>
                               </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="contact" class="col-sm-3 col-form-label">Phone:</label>
                                <div class="col-sm-9">
                                    <form:input path="phoneNumber" autocomplete="off" type="text" class=" form-control-sm auto-val" name="phoneNumberId" id="phoneNumberId"/>
                                     <span id="phoneNumberError" style="color:red"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label for="client-address" class="col-sm-2 col-form-label">Address:</label>
                                <div class="col-sm-10">
                                    <form:input path="address" autocomplete="off" type="text" class=" form-control-sm auto-val" name="contact" id="clientAddressId"/>
                                    <span id="addressError" style="color:red"></span>
                                
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
                                        <label for="client-name" class="col-sm-12 text-center col-form-label">Client Name</label>
                                          
                                    </div>
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:input path="clientName" autocomplete="off" type="text" class="billing-name-txt form-control-sm auto-val" name="clientNameId" id="clientNameId"/>
                                            <span id="clientNameError" style="color:red"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mt-2 billing-name-box" style="border-left: 2px solid #fff; border-right: 4px solid #fff;">
                            <div class="row mb-n2 mt-2">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <label for="billing-number" class="col-sm-12 col-form-label">Bill No.: ${billNumber} </label>
										<form:hidden path="billingNumber" value="${billNumber}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col-md-12">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <label>Date  : ${systemDate} </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-1 row-bg">
                <div class="col-md-2 mt-2">
                    <div class="form-group">
                        <label for="product-name">Product Name</label>
                        <form:select path="product" items="${productMasterList}" onchange='getDropdownId(this)' itemValue="productId" id="productId" itemLabel="productName" cssClass="form-control form-control-sm" />
                        <span id="productError" style="color:red"></span>
                    </div>
                </div>
                
                     <div class="col-md-2 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Unit Type</label>
                        <form:input path="perKgOrPice" type="text" autocomplete="off" class=" form-control form-control-sm auto-val" id="perKgOrPiceId"  name="perKgOrPice" placeholder="Per Kg Or Pice"/>
                    </div>
                </div>
                
                <div class="col-md-2 mt-2">
                    <div class="form-group">
                        <label for="product-unit">Unit</label>
                        <form:input path="unit" type="text" autocomplete="off" class=" form-control form-control-sm " id="productUnitId" onkeyup="totalSum();" name="product-unit " placeholder="Product Unit"/>
                    </div>
                </div>
                <div class="col-md-2 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Rate</label>
                        <form:input path="rate" type="text" autocomplete="off" class=" form-control form-control-sm " id="productRateId" onkeyup="totalSum();" name="product-rate" placeholder="Product Rate"/>
                    </div>
                </div>
                
                  <div class="col-md-2 mt-2">
                    <div class="form-group">
                        <label for="product-rate">Total</label>
                        <form:input path="sum" type="text" autocomplete="off" class=" form-control form-control-sm auto-val" id="sumId" name="product-rate" placeholder="Total Product Rate"/>
                    </div>
                </div>
                
                <div class="col-md-2 mt-5">
                    <div class="form-group">
                        <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" 
                               onclick="return validateDropdown();" >
                         Add Item In List</button>
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
                              <c:forEach var="shopeCreateOrderForSale" varStatus="counter" items="${shopeCreateOrderForSaleList}">	
                                <tr>
                                <td>${counter.count}</td>
                                <td>${shopeCreateOrderForSale.productName}</td>
                                <td>${shopeCreateOrderForSale.unit}</td>
                                <td class="text-left">${shopeCreateOrderForSale.rate}</td>
                                <td class="text-left">${shopeCreateOrderForSale.perKgOrPiece}</td>
                                <td class="text-left">&#x20B9; ${shopeCreateOrderForSale.sum}</td>
                                <td>
                                    <form:hidden path = "id" id = "id" value="${shopeCreateOrderForSale.id}"/>
                                    <div class="btn-group" role="group" aria-label="Basic example">                               
                                      <a href="#" onclick="submitFormByAction('shopeCreateOrderForSale','<spring:url value="/deleteProductById"/>')">
                                       <button type="button" class="btn btn-danger btn-sm">Remove</button></a>                                        
                                    </div>
                                    <%--  &nbsp; &nbsp;<a href="${contextPath}/deleteProductById?productId=${shopeCreateOrderForSale.id}"><button type="button" class="btn btn-danger btn-sm">Remove</button></a> --%>
                                </td>
                            </tr>
                           </c:forEach>
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
                            <form:input path="billAmount" type="text " class="form-control-sm auto-val" name="billAmountId" value="${billAmount}" id="billAmountId"/>
                        </div>
                    </div>
                    <div class="form-group row ">
                        <label for="bill-amount " class="col-sm-6 col-form-label "><strong>Paid Amount:</strong></label>
                        <div class="col-sm-6 ">
                            <form:input path="paidAmount" type="text " class="form-control-sm " name="paidAmountId" onkeyup="paidAmountFun();" value="" id="paidAmountId"/>
                        </div>
                    </div>
                    
                    <div class="form-group row ">
                        <label for="bill-amount " class="col-sm-6 col-form-label "><strong>Unpaid Amount:</strong></label>
                        <div class="col-sm-6 ">
                            <form:input path="unPaidAmount" type="text " class="form-control-sm auto-val"    name="unPaidAmountId" value="" id="unPaidAmountId"/>
                        </div>
                    </div>
                    
                     <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" 
                             onclick="return validateForm();" >Generate Order</button>
                     <input type="hidden" name="command">
              
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
					  $("#sumId").val(parseInt(data.unit)*parseInt(data.rate));
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
			  $("#sumId").val(parseInt(data.unit)*parseInt(data.rate));
			  
	        },
	        error:function(error){
	        	alert(data);
	        }
	    });  
    });
    
    
    
    
    function totalSum() {
	      var txtFirstNumberValue = parseInt($("#productUnitId").val());
	      var txtSecondNumberValue = parseInt($("#productRateId").val());
	      if(isNaN(txtFirstNumberValue)){
	    	  txtFirstNumberValue=0;
	      }
	      if(isNaN(txtSecondNumberValue)){
	    	  txtSecondNumberValue=0;
	      }
	      var result = parseInt(txtFirstNumberValue) * parseInt(txtSecondNumberValue);
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
		      var txtFirstNumberValue = parseInt($("#billAmountId").val());
		      var txtSecondNumberValue = parseInt($("#paidAmountId").val());
		      
		      if(isNaN(txtFirstNumberValue)){
		    	  txtFirstNumberValue=0;
		      }
		      if(isNaN(txtSecondNumberValue)){
		    	  txtSecondNumberValue=0;
		      }
		      var result = parseInt(txtFirstNumberValue) - parseInt(txtSecondNumberValue);
		      if (!isNaN(result)) {
		         $("#unPaidAmountId").val(result);
		      }
		}
	    
	 
	 
	
</script>
    
    
           
                                                      


</html>