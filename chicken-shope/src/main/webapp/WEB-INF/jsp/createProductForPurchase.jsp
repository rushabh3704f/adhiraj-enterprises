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
    
    <link href="css/common.css" rel="stylesheet">

    <!-- Data Table CDN -->
    <link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<spring:url value="/createPurchaseProduct" var="url"></spring:url>
    <form:form name="shopeCreateProductForPurchase" id="shopeCreateProductForPurchase" commoandName="shopeCreateProductForPurchase" modelAttribute="shopeCreateProductForPurchase" action="${url}" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page margin-top background-color">
        <div class="container">
            <div class="row row-bg user-detail">
                <div class="col-md-6 col-6">
                    <div class="page-path">
                        <div class="page-name mb-2">
                            Sale Product List
                        </div>
                        <i class="fa fa-home"></i>/ My Account / <b>Sale Product List</b>
                    </div>
                </div>
                <div class="col-md-6 col-6">
                    <div class="add-new-client float-right mt-3">
                        <button type="button" class=" btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-product-modal" onclick="addSaleProduct()">Add New</button>
                    </div>
                </div>
            </div>
            <div class="row mt-1 row-bg user-detail datatable-class">
                <div class="col-md-12 mt-3 add-product-price-table">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Category</th>
                                <th>Product Name</th>
                                <th>Unit</th>
                                <th>Unit Type</th>
                                <th>Rate</th>
                                <th>Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
       					  <c:forEach var="shopeCreateProductForPurchaseList" varStatus="counter" items="${shopeCreateProductForPurchaseList}">                    
                            <tr>
                                <td>${counter.count}</td>
                                <td>${shopeCreateProductForPurchaseList.category}</td>
                                <td>${shopeCreateProductForPurchaseList.productName}</td>
                                <td>${shopeCreateProductForPurchaseList.unit}</td>
                                <td>${shopeCreateProductForPurchaseList.unitType}</td>
                                <td>${shopeCreateProductForPurchaseList.rate}</td>
                                <td>${shopeCreateProductForPurchaseList.createdOn}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                     <form:hidden path = "id" id = "id"/>
                                      <form:hidden path = "productId" id = "productId"/>
                                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#add-new-product-modal" 
                                        onclick="updateCreatedPurchaseProduct('${shopeCreateProductForPurchaseList.category}'
                                        		,'${shopeCreateProductForPurchaseList.productName}'
                                        		,'${shopeCreateProductForPurchaseList.unit}'
                                        		,'${shopeCreateProductForPurchaseList.unitType}'
                                        		,'${shopeCreateProductForPurchaseList.id}'
                                        		,'${shopeCreateProductForPurchaseList.productId}'
                                        		,'${shopeCreateProductForPurchaseList.rate}')">
                                         Update</button>
                                        &nbsp;<a href="/deleteCreatedPurchaseProductById?purchaseProductId=${shopeCreateProductForPurchaseList.id}"><button type="button" class="btn btn-danger btn-sm">Remove</button></a>
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
   


    <!-- Model For Add Product -->
    <!-- Modal -->
    <div class="modal fade in" id="add-new-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title" id="exampleModalLabel">Add Product</h6>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
                </div>
                <div class="modal-body add-client-proprity">
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="product-category" class="col-form-label">Category:</label>
                        </div>
                        <div class="col-md-9">
                            <form:select path="category" class="form-control-sm" name="categoryId" id="categoryId">
                                <option value="Chicken">Chicken</option>
                                <option value="Mutton">Mutton</option>
                                <option value="Egg">Egg</option>
                            </form:select>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3 pr-0">
                            <label for="product-name" class="col-form-label">Product Name:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="productName" type="text" autocomplete="off" class="form-control-sm" name="productNameId" id="productNameId" placeholder="Enter Product Name"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="unit" class="col-form-label">Unit:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="unit" type="text" autocomplete="off" class="form-control-sm" name="unitId" id="unitId" placeholder="Enter Unit"/>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="unit-type" class="col-form-label">Unit Type:</label>
                        </div>
                        <div class="col-md-9">
                            <form:select path="unitType" class="form-control-sm" name="unitTypeId" id="unitTypeId">
                                <option>Kg</option>
                                <option>Piece</option>
                            </form:select>
                        
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-md-3">
                            <label for="rate" class="col-form-label">Rate:</label>
                        </div>
                        <div class="col-md-9">
                            <form:input path="rate" type="text" autocomplete="off" class="form-control-sm" name="rateId" id="rateId" placeholder="Enter Rate"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer" id="createDivId">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.shopeCreateProductForPurchase.command.value='createPurchaseProduct'" >Create</button>
                </div>
                <div class="modal-footer" id="updateDivId">
                    <button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">Close</button>
                    <button name="commandPass" type="submit" value="submit" class="btn btn-success btn-sm" onclick="document.shopeCreateProductForPurchase.command.value='updatePurchaseProduct'" >Update</button>
                </div>
                <input type="hidden" name="command">
            </div>
        </div>
    </div>
    <!-- Model For Add Product End -->
 </form:form>
   

    <script src="vendor/jquery/jquery-3.3.1.slim.min.js " type="text/javascript "></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js " type="text/javascript "></script>
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
    </script>
    
      <script>
     function addSaleProduct(){
    	 
    	 $("#createDivId").show();
    	 $("#updateDivId").hide();
    	 $("#id").val('');
    	 $("#unitId").val('');
    	 $("#rateId").val('');
    	 $('#add-new-product-modal').modal('show');
     }
          
     
    function updateCreatedPurchaseProduct(categoryId,productNameId,unitId,unitTypeId,id,productId,rateId){
    	 //alert(id);
    	 $("#createDivId").hide();
    	 $("#updateDivId").show();
    	 $("#categoryId").val(categoryId);
    	 $("#productNameId").val(productNameId);
    	 $("#unitId").val(unitId);
    	 $("#unitTypeId").val(unitTypeId);
    	 $("#id").val(id);
    	 $("#id").val(id);
    	 $("#productId").val(productId); 
    	 $('#add-new-product-modal').modal('show');
     }
    
     </script>
    
    

</html>