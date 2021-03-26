<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!doctype html>
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
    <link href="css/common.css" rel="stylesheet">

    <!-- Data Table CDN -->
    <link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<spring:url value="/createClient" var="url"></spring:url>
    <form:form name="shopeCreateClient" id="shopeCreateClient" commoandName="shopeCreateClient" modelAttribute="shopeCreateClient" action="${url}" method="post">
	<jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-6 col-6">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Client List
                        </div>
                        <i class="fa fa-home"></i>/ Create / <b>Client List</b>
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <button class=" btn btn-success btn-sm" type="button" data-toggle="modal" data-target="#add-new-client-modal" onclick="addNewClient()">Add New</button>
                    </div>
                </div>
            </div>

            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3 client-list-table">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No.</th>
                                <th>Name</th>
                                <th>Billing Name</th>
                                <th>Phone</th>
                                <th>Date</th>
                                <th>Address</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="shopeCreateClient" varStatus="counter" items="${shopeCreateClientList}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${shopeCreateClient.clientName}</td>
                                <td>${shopeCreateClient.billingName}</td>
                                <td>${shopeCreateClient.phoneNumber}</td>
                                <td>${shopeCreateClient.createdOn}</td>
                                <td>${shopeCreateClient.address}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-client-modal" onclick="updateClientById('${shopeCreateClient.id}','${shopeCreateClient.clientId}','${shopeCreateClient.clientName}','${shopeCreateClient.billingName}','${shopeCreateClient.phoneNumber}','${shopeCreateClient.address}')">Update</button>
                                        &nbsp;<a href="${contextPath}/deleteClientById?clientId=${shopeCreateClient.id}"><button type="button" class="btn btn-danger btn-sm">Remove</button></a>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </section>
    <jsp:include page="footer.jsp" />


    <!-- Model For Add Client -->
    <!-- Modal -->
    <div class="modal fade" id="add-new-client-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title" id="exampleModalLabel">Add Client</h6>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
                </div>
                <div class="modal-body add-client-proprity">
                
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="client-name" class="col-form-label">Client Id:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="clientId" type="text" class="form-control-sm" name="newClientId" id="newClientId"/>
                        </div>
                    </div>
                
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="client-name" class="col-form-label">Client Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="clientName" autocomplete="off" type="text" class="form-control-sm" name="clientNameId" id="clientNameId"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="billing-name" class="col-form-label">Billing Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="billingName" type="text" autocomplete="off" class="form-control-sm" name="billingNameId" id="billingNameId"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="contact-number" class="col-form-label">Phone:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="phoneNumber" type="text" autocomplete="off" class="form-control-sm" name="phoneNumberId" id="phoneNumberId"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="address" class="col-form-label">Address:</label>
                        </div>
                        <div class="col-md-9">
                            <form:textarea path="address" class="form-control" autocomplete="off" name="address" id="addressId" rows="3" style="resize: none;"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.shopeCreateClient.command.value='createClient'" >Submit</button>
                    <form:hidden path = "id" id = "id"/>
                </div>
            </div>
        </div>
    </div>
    <!-- Model For Add Client End -->
    <input type="hidden" name="command">
    </form:form>

    <script src="vendor/jquery/jquery-3.3.1.slim.min.js " type="text/javascript "></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>

    <script src="vendor/select2/js/select2.min.js " type="text/javascript "></script>

    <script src="js/custom.js " type="text/javascript "></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>



    <script>
        $(document).ready(function() {
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

        // $(document).ready(function() {
        //     $('#example').DataTable();
        // });

        $(document).ready(function() {
            $('#example').dataTable({
                aaSorting: [
                    [0, 'asc']
                ]
            })
        });

        
    function addNewClient(){
  	  var clientId=0;
  	  //${Constants.BASE_URL}
	   $.ajax({
	        url : '${BASE_URL}/getClientId?clientId='+ clientId,
	        type : 'post',
	        success : function(data) {
	        	      $("#newClientId").val(data);
	        	      $("#id").val('');
	        	      $("#clientNameId").val('');
	        	      $("#billingNameId").val('');
	        	      $("#phoneNumberId").val('');
	        	      $("#addressId").val('');
	        	      $("#newClientId").val(data);
	        	      $('#add-new-client-modal').modal('show'); 
	        },
	        error:function(error){
	        	alert(data);
	        }
	    });  		        	 
     }
     
     
    function updateClientById(id,clientId,clientName,billingName,phoneNumber,address){
    	 $("#id").val(id);
    	 $("#newClientId").val(clientId);
    	 $("#clientNameId").val(clientName);
    	 $("#billingNameId").val(billingName);
    	 $("#phoneNumberId").val(phoneNumber);
    	 $("#addressId").val(address);
    	 $('#add-new-client-modal').modal('show');
    }
 
    
 </script>
    
    
    
    
    
    

</html>