<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light maizil-nav shadow-sm border-position">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                Alam Enterprises
            </a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/createNewOrder"> New Order </a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i> Create </a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/createClient">
                                Customer</a>
                            <a class="dropdown-item" href="${contextPath}/createEmployee">
                                Employee</a>
                            <a class="dropdown-item" href="${contextPath}/createEmpSalary">
                                Emp Salary</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i> Purchase</a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/createNewPurchaseOrder"> Purchase</a>
                            <a class="dropdown-item" href="${contextPath}/purchaseOrderList"> Purchase List</a>
                        </div>
                    </li>
                    
                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i> Sale</a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/createNewOrder"> New Order </a>
                            <a class="dropdown-item" href="${contextPath}/orderList"> Order List</a>
                        </div>
                     </li>
                     
                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i>Product-Config</a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/createSaleProduct">Create Product For Sale</a>
                            <a class="dropdown-item" href="${contextPath}/createPurchaseProduct">Create Product For Purchase</a>
                        </div>
                     </li>
                     
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="icofont-live-support"></i>Reports</a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/salesReport">Sales Report</a>
                            <a class="dropdown-item" href="${contextPath}/purchaseReport">Purchase Report</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="icofont-live-support"></i> Alam Enterprises
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow-sm border-0 mt-2">
                            <a class="dropdown-item" href="${contextPath}/loginPage"> Log Out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>