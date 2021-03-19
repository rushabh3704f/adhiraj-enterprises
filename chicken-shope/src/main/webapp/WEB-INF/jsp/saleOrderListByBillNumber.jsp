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
	<spring:url value="/updateProductForSale" var="url"></spring:url>
	
    <form:form name="productDetailsForSale" id="productDetailsForSale" commoandName="productDetailsForSale" modelAttribute="productDetailsForSale" action="${url}" method="post">
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
                                        <a href="${contextPath}/deleteProductDetailsForSale?productId=${productDetailsForSaleList.id}&billNumber=${productDetailsForSaleList.billingNumber}" class="btn btn-dark btn-sm">Delete</a>
                                       <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-employee-modal" onclick="updateProduct('${productDetailsForSaleList.id}','${productDetailsForSaleList.billingNumber}','${productDetailsForSaleList.productName}','${productDetailsForSaleList.unit}','${productDetailsForSaleList.rate}','${productDetailsForSaleList.sum}');">Update</button>                                    
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        
        
       
        <div class="modal fade in" id="add-new-employee-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title" id="exampleModalLabel">Add Employee</h6>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
                </div>
                <div class="modal-body add-client-proprity">
                
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Bill Number:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="billingNumber" type="text" class="form-control-sm" name="billingNumber" id="billingNumberId"/>
                        </div>
                    </div>
                      <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Product Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="productName" type="text" class="form-control-sm" name="productId" id="productId"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Unit:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="unit" type="text" class="form-control-sm" onkeyup="totalSum();" autocomplete="off" name="unitId" id="unitId"/>
                        </div>
                    </div>
                     <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Rate:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="rate" type="text" class="form-control-sm" name="rateId" id="rateId"/>
                        </div>
                    </div>
                     <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Sum:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="sum" type="text" class="form-control-sm" name="sumId" id="sumId"/>
                        </div>
                    </div>
                   <form:hidden path="id" id="productUniqueId" name="productUniqueId"/>
                    
                    
                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.productDetailsForSale.command.value='updateProduct'" >Submit</button>
                    <input type="hidden" name="command">
                     <!-- <input type="hidden" name="id" id="id"> -->
                    
               
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
        
        
        function updateProduct(id,bill,product,unit,rate,sum){
        	     alert(id);
        	   	 $("#productUniqueId").val(id);
            	 $("#billingNumberId").val(bill);
            	 $("#productId").val(product);
            	 $("#unitId").val(unit);
            	 $("#rateId").val(rate);
            	 $("#sumId").val(sum);
     	      $('#add-new-employee-modal').modal('show');

        }
        
   	 
   	 function totalSum(){
   		     var totalSum = parseInt($("#unitId").val()) * parseInt($("#rateId").val());
   		     document.getElementById("sumId").value = totalSum;
   	 }
        
        
        
        
    </script>

</html>