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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/maizil.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">

    <!-- Data Table CDN -->
    <link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<spring:url value="/createEmpSalary" var="url"></spring:url>
    <form:form name="shopeCreateEmployeeSalary" id="shopeCreateEmployeeSalary" commoandName="shopeCreateEmployeeSalary" modelAttribute="shopeCreateEmployeeSalary" action="${url}" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-6 col-6">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Employee Salary List
                        </div>
                        <i class="fa fa-home"></i>/ Create / <b>Employee Salary List</b>
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <button class=" btn btn-success btn-sm" type="button" data-toggle="modal" data-target="#exampleModalLabelId" onclick="empSalaryModal()">Pay Salary</button>
                    </div>
                </div>
            </div>

               <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-5"></div>
                <div class="col-md-12 mt-3">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>Sr.No.</th>
                                <th>Name</th>
                                <th>Leaves</th>
                                <th>Salary</th>
                                <th>Payment</th>
                                <th>Pending Salary</th>
                                <th>Total Salary</th>
                                <th>Payment Date</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="shopeCreateEmployeeSalary" varStatus="counter" items="${shopeCreateEmployeeSalaryList}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${shopeCreateEmployeeSalary.firstName}</td>
                                <td>${shopeCreateEmployeeSalary.leaveInDays}</td>
                                <td>${shopeCreateEmployeeSalary.salary}</td>
                                <td>${shopeCreateEmployeeSalary.payment}</td>
                                <td>${shopeCreateEmployeeSalary.pendingSalary}</td>
                                <td>${shopeCreateEmployeeSalary.totalSalary}</td>
                                <td>${shopeCreateEmployeeSalary.paymentDate}</td>
                                <td>${shopeCreateEmployeeSalary.createdOn}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <form:hidden path = "id" id = "id"/>
                                       <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#emp-salary-modal" 
                                               onclick="updateEmpSalById('${shopeCreateEmployeeSalary.id}'
                                               							,'${shopeCreateEmployeeSalary.firstName}'
                                               							,'${shopeCreateEmployeeSalary.leaveInDays}'
                                               							,'${shopeCreateEmployeeSalary.salary}'
                                               							,'${shopeCreateEmployeeSalary.payment}'
                                               							,'${shopeCreateEmployeeSalary.pendingSalary}'
                                               							,'${shopeCreateEmployeeSalary.paymentDate}'
                                               						    ,'${shopeCreateEmployeeSalary.createdOn}'
                                               							)">
                                               Update</button>
                                        &nbsp;<a href="${contextPath}/deleteSalaryById?clientId=${shopeCreateEmployeeSalary.id}"><button type="button" class="btn btn-danger btn-sm">Remove</button></a>
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

    <!-- Model For Add Employee -->
    <!-- Modal -->
    <div class="modal fade in" id="exampleModalLabelId" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title" id="exampleModalLabel">Employee Salary</h6>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="#">
                    <div class="modal-body add-client-proprity">
                        <div class="row mb-2">
                            <div class="col-md-3 pr-0">
                                <label for="employee-name" class="col-form-label">Employee Name:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="firstName" list="firstName" id="firstNameId" name="firstNameId" autocomplete="off" class="form-control-sm"/>
								  <datalist id="firstName">
								     <c:forEach var="shopeCreateEmp" varStatus="counter" items="${shopeCreateEmployeeList}">	
								    	 <option id="${shopeCreateEmp.employeeId}" value="${shopeCreateEmp.firstName}"/>
								     </c:forEach>
								 </datalist>
								 
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="emp-salary" class="col-form-label">Salary:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="salary" type="text" class="form-control-sm" name="salaryId" id="salaryId"/>
                            </div>
                        </div>
                        
                        <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="leaves" class="col-form-label">Leaves:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="leaveInDays"  class="form-control-sm" name="leaveInDaysId" onkeyup='getTotalSalary(this)' type="number" min="1" max="30" id="leaveInDaysId"/>
                            </div>
                        </div>
                        
                        <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="total-salary" class="col-form-label">Total Salary:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="totalSalary" type="text" class="form-control-sm" name="totalSalId" id="totalSalId"/>
                            </div>
                        </div>
                        
                        
                          <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="emp-salary" class="col-form-label">Payment:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="payment" type="text" class="form-control-sm" name="paymentId" onkeyup="paymentFun(this);" id="paymentId"/>
                            </div>
                         </div>
                         
                         
                         <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="emp-salary" class="col-form-label">Pending Salary:</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="pendingSalary" type="text" class="form-control-sm" name="pendingSalaryId" id="pendingSalaryId"/>
                            </div>
                         </div>
                        
                        <div class="row mb-2">
                            <div class="col-md-3">
                                <label for="leaves" class="col-form-label">Date:</label>
                            </div>
                            <div class="col-md-9">
                              <form:input path="paymentDate" type="date" class="form-control-sm" name="paymentDateId" id="paymentDateId"/>
                              </div>
                        </div>
                        
                     

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                        <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.shopeCreateEmployeeSalary.command.value='createSalary'" >Submit</button>
                        <input type="hidden" name="command">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Model For Add Employee End -->

   
    <!-- Model For Add Update Employee End -->
    </form:form>
    <script src="vendor/jquery/jquery-3.3.1.slim.min.js " type="text/javascript "></script>
    <script src="vendor/jquery/customJquery.js" type="text/javascript"> </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    
   <!--  <script src="vendor/jquery/jquery-3.5.1.slim.min.js " type="text/javascript "></script> -->
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>
    <script src="vendor/select2/js/select2.min.js " type="text/javascript "></script>

    <script src="js/custom.js " type="text/javascript "></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
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



     function updateEmpSalById(id,fname,ldays,sal,payment,pending,paymentDate,createdOn){
    	 alert(createdOn);
    	 //===================================================
    	 /* var d = new Date(createdOn);
    	 const formatYmd = date => d.toISOString().slice(0, 10);
    	 var date1=formatYmd(new Date());
    	 alert(date1); */
    	     	 
    	 $("#id").val(id);
    	 $("#firstNameId").val(fname);
    	 $("#leaveInDaysId").val(ldays);
    	 $("#salaryId").val(sal);
    	 $("#paymentId").val(payment);
    	 $("#pendingSalaryId").val(pending);
    	 //$("#paymentDateId").val(paymentDate);
    	 //$("#totalsalaryId").val(pending);
    	 $('#emp-salary-modal').modal('show');
     }
     

    function empSalaryModal(){
    	 $('#empSalaryModal').modal('show');
     }
     
    function get_data(elem){
    	  alert(elem.value);
    	  var g = document.getElementById("firstName").options.id; 
    	  var opt = $('option[value="'+$(this).val()+'"]');
    	  alert(opt);
    	}

    
    $(function() {
		  $('#firstNameId').on('input',function() {
		    var opt = $('option[value="'+$(this).val()+'"]');
		    //alert(opt.length ? opt.attr('id') : 'NO OPTION');
		    if(opt.length > 0){
		    	var employeeId=opt.attr('id');
		    	//alert(billingNameId);
		    	//--------------------
		    	   $.ajax({
		   	        url : 'http://localhost:8080/digitalShope/getEmployeeSalary?employeeId='+ employeeId,
		   	        type : 'post',
		   	        success : function(data) {
		   	  				  //alert(data.salary);
		   	  				  $("#salaryId").val(data.salary);
		   	        },
		   	        error:function(error){
		   	        	alert(data);
		   	        }
		   	    }); ///Ajax end
		    	
		    }//if body end
		    
		  });
	 });//function end
    
	 
	 function getTotalSalary(){
		     var oneDaySalary = Math.round(parseInt($("#salaryId").val())/30);
		     var totalPresentDay=30-parseInt($("#leaveInDaysId").val());
		     //alert(totalPresentDay);
		     //alert(oneDaySalary);
		     var totalSalary = parseInt(totalPresentDay) * parseInt(oneDaySalary);
		     //alert(totalSalary);
		     document.getElementById("totalSalId").value = totalSalary;
	 }
	 
	 
	 function paymentFun(){
		 	var pending= parseInt($("#totalSalId").val()-$("#paymentId").val());
		    document.getElementById("pendingSalaryId").value = pending;
	 }
	 
    
     
  </script>
    
    

</html>