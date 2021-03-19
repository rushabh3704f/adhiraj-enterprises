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
	<spring:url value="/createEmployee" var="url"></spring:url>
    <form:form name="shopeCreateEmployee" id="shopeCreateEmployee" commoandName="shopeCreateEmployee" modelAttribute="shopeCreateEmployee" action="${url}" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-6 col-6">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Employee List
                        </div>
                        <i class="fa fa-home"></i>/ Create / <b>Employee List</b>
                        <div align="center" style="color:red">${msg}</div>
                        
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <button class=" btn btn-success btn-sm" type="button" data-toggle="modal" data-target="#add-new-employee-modal" onclick="addNewEmployee()">Add New</button>
                    </div>
                </div>
            </div>

            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Designation</th>
                                <th>Salary</th>
                                <th>Date</th>
                                <th>Address</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="shopeCreateEmployee" varStatus="counter" items="${shopeCreateEmployeeList}">	
                            <tr>
                                <td>${counter.count}</td>
                                <td>${shopeCreateEmployee.firstName}</td>
                                <td>${shopeCreateEmployee.phoneNumber}</td>
                                <td>${shopeCreateEmployee.designation}</td>
                                <td>${shopeCreateEmployee.salary}</td>
                                <td>${shopeCreateEmployee.createdOn}</td>
                                <td>${shopeCreateEmployee.address}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                       <form:hidden path = "id" id = "id"/>
                                       <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-employee-modal" onclick="updateEmployeeData('${shopeCreateEmployee.employeeId}','${shopeCreateEmployee.id}','${shopeCreateEmployee.firstName}','${shopeCreateEmployee.middleName}','${shopeCreateEmployee.lastName}','${shopeCreateEmployee.phoneNumber}','${shopeCreateEmployee.designation}','${shopeCreateEmployee.salary}','${shopeCreateEmployee.address}');">Update</button>                                    
                                        &nbsp; &nbsp;<a href="${contextPath}/deleteEmployeeById?employeeId=${shopeCreateEmployee.id}"><button type="button" class="btn btn-danger btn-sm">Remove</button></a>
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
  
    <!-- Model For Add Employee -->
    <!-- Modal -->
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
                            <label for="employee-name" class="col-form-label">Employee Id:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="employeeId" type="text" class="form-control-sm" name="employeeId" id="employeeId"/>
                        </div>
                    </div>
                
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">First Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="firstName" type="text" class="form-control-sm" name="firstName" id="firstNameId"/>
                        </div>
                    </div>
                    
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Middle Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="middleName" type="text" class="form-control-sm" name="middleNameId" id="middleNameId"/>
                        </div>
                    </div>
                    
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="employee-name" class="col-form-label">Last Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="lastName" type="text" class="form-control-sm" name="employee-name" id="lastNameId"/>
                        </div>
                    </div>
                    
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="contact-number" class="col-form-label">Phone:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="phoneNumber" type="text" class="form-control-sm" name="contact-number" id="phoneNumberId"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="designation" class="col-form-label">Designation:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="designation" type="text" class="form-control-sm" name="designation" id="designationId" placeholder="( Optional )"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="salary" class="col-form-label">Salary:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="salary" type="text" class="form-control-sm" name="salary" id="salaryId" placeholder="(Optional)"/>
                        </div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="address" class="col-form-label">Address:</label>
                        </div>
                        <div class="col-md-9">
                            <form:textarea path="address" class="form-control" name="address" id="addressId" rows="3" style="resize: none;"/></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.shopeCreateEmployee.command.value='addEmployee'" >Submit</button>
                </div>
            </div>
        </div>
    </div>
  <jsp:include page="footer.jsp" />  
  <input type="hidden" name="command">
  </form:form>
    <!-- Model For Add Update Employee End -->

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

     
     function updateEmployeeData(employeeId,id,firstName,middleName,lastName,phoneNumer,designation,salary,address){
    	 
    	 //alert(firstName);
    	 $("#id").val(id);
    	 $("#employeeId").val(employeeId);
    	 $("#firstNameId").val(firstName);
    	 $("#middleNameId").val(middleName);
    	 $("#lastNameId").val(lastName);
    	 $("#phoneNumberId").val(phoneNumer);
    	 $("#designationId").val(designation);
    	 $("#salaryId").val(salary);
    	 $("#addressId").val(address);
    	 $('#add-new-employee-modal').modal('show');
     }
     
     
     
     function addNewEmployee(){
      
      var clientId=0;
   	   $.ajax({
   	        url : 'http://localhost:8080/digitalShope/getEmployeeId?clientId='+ clientId,
   	        type : 'post',
   	        success : function(data) {
   	        	      $("#employeeId").val(data);
   	          	      $("#id").val('');
	   	         	  $("#firstNameId").val('');
	   	         	  $("#middleNameId").val('');
	   	         	  $("#lastNameId").val('');
	   	         	  $("#phoneNumberId").val('');
	   	         	  $("#designationId").val('');
	   	         	  $("#salaryId").val('');
	   	         	  $("#addressId").val('');
   	        	      $('#add-new-employee-modal').modal('show');
   	        },
   	        error:function(error){
   	        	alert(data);
   	        }
   	    });  		        	 
        }
     
     
     
     </script>
    

</html>