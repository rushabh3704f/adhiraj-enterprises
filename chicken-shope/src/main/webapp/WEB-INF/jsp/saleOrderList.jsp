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
                           Sale Order List
                        </div>
                        <i class="fa fa-home"></i>/ My Account / <b>Sale Order List</b>
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <a href="/createNewOrder" class="btn btn-success btn-sm">New Order</a>
                    </div>
                </div>
            </div>

            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                               	<th>ID</th>
								<th>Client Name</th>
								<th>Billing Name</th>
								<th>Bill Amount</th>
								<th>Paid Amount</th>
								<th>Un-Paid Amount</th>
								<th>Date</th>
								<th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="billingDetailsForSaleList" varStatus="counter" items="${billingDetailsForSaleList}">
                            <tr>
                               <td>${counter.count}</td>
								<td>${billingDetailsForSaleList.clientName}</td>
								<td>${billingDetailsForSaleList.billingName}</td>
								<td>${billingDetailsForSaleList.billAmount}</td>
								<td>${billingDetailsForSaleList.paidAmount}</td>		
								<td>${billingDetailsForSaleList.unPaidAmount}</td>							
								<td>${billingDetailsForSaleList.createdOn}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <a href="/saleOrderListByBillNumber?billNumber=${billingDetailsForSaleList.billingNumber}"><button type="button" class="btn btn-outline-dark btn-sm">View</button></a>
                                        &nbsp;<a href="/invoiceDetails?billNumber=${billingDetailsForSaleList.billingNumber}"><button type="button" class="btn btn-primary btn-sm">Invoice</button></a>
                                        &nbsp;<a href="/paymentHistoryDetails?billingNumber=${billingDetailsForSaleList.billingNumber}"><button type="button" class="btn btn-info btn-sm">Payment History</button></a>
                                        &nbsp;<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-employee-modal" onclick="rePayment('${billingDetailsForSaleList.billingNumber}','${billingDetailsForSaleList.billAmount}','${billingDetailsForSaleList.paidAmount}','${billingDetailsForSaleList.unPaidAmount}');">Re-Pay</button>                                    
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
                            <form:input path="billingNumber" type="text" class="form-control-sm auto-val" name="billingNumber" id="billingNumberId"/>
                        </div>
                    </div>
                    
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Bill Amount:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="sum" type="text" class="form-control-sm auto-val" name="sumId" id="sumId"/>
                        </div>
                    </div>
                    
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Paid Amount:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="paidAmount" type="text" class="form-control-sm auto-val" name="paidAmount" id="paidAmountId"/>
                        </div>
                    </div>
                    
                     <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Un Paid Amt:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="unPaidAmount" type="text" class="form-control-sm auto-val" name="unPaidAmountId" id="unPaidAmountId"/>
                        </div>
                    </div>
                    
                    
                      <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Re-Pay Amt:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="rePayAmount" type="text" class="form-control-sm"  name="rePayAmountId" id="rePayAmountId"/>
                        </div>
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="rePaymentFunction()" >Submit</button>
                    <input type="hidden" name="command">
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
        
        
        function rePayment(billNo,billAmount,paidAmount,unPaidAmount){
          $('#billingNumberId').val(billNo);
          $('#sumId').val(billAmount);
          $('#paidAmountId').val(paidAmount);
          $('#unPaidAmountId').val(unPaidAmount);
   	      $('#add-new-employee-modal').modal('show');
        }
        
        
   	 function rePaymentFunction(){
	     var paidAmount = parseInt($("#paidAmountId").val())+parseInt($("#rePayAmountId").val());
	     var unPaidAmount = parseInt($("#unPaidAmountId").val())-parseInt($("#rePayAmountId").val());
	     $('#paidAmountId').val(paidAmount);
         $('#unPaidAmountId').val(unPaidAmount);
         document.productDetailsForSale.command.value='rePay';
         
 	}
        
       
        
        
    </script>


</html>