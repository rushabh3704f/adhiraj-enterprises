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

    <link rel="icon" type="image/png" href="https://zmdownload.zoho.com/view?attachId=138223803554330290&entityType=1&entityId=1603087703852110003&accId=5734614000000008002&height=1024&width=1024">

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="vendor/fontawesome/css/all.min.css" rel="stylesheet">

    <link href="vendor/icofont/icofont.min.css" rel="stylesheet">

    <link href="css/maizil.css" rel="stylesheet">
</head>

<body class="bg-white">
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <spring:url value="/loginPage" var="url"></spring:url>
	<form:form name="loginPage" id="loginPage" commoandName="loginPage" modelAttribute="loginPage" action="${url}" method="post">
    <div class="container-fluid">
        <div class="row no-gutter">
            <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
            <div class="col-md-8 col-lg-6">
                <div class="login d-flex align-items-center py-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-9 col-lg-8 mx-auto pl-5 pr-5">
                                <h4 ></h3><span><strong style="color:red">${error}</strong></span></h4>
                                <br>
                                <h3 class="login-heading mb-4">Welcome back!</h3>
                                
                                <form>
                                    <div class="form-label-group">
                                        <form:select path="userType" class="form-control" name="shop-name" id="shop-name" style="box-shadow: 0 0px 0px rgba(0, 0, 0, 0.1)!important;">
                                            <option>Alam Enterprises</option>
                                            <option>S. S. G. Food</option>
                                        </form:select>
                                    </div>
                                    <div class="form-label-group">
                                        <form:input path="userName" type="email" id="userNameId" class="form-control" placeholder="Email address"/>
                                        <label for="userNameId">User Name </label>
                                    </div>
                                    <div class="form-label-group">
                                        <form:input path="password" type="password" id="passwordId" class="form-control" placeholder="Password"/>
                                        <label for="passwordId">Password</label>
                                    </div>

	                                <div class="modal-footer">
					                    <button name="commandPass" type="submit" value="submit" class="btn btn-lg btn-outline-primary btn-block btn-login text-uppercase font-weight-bold mb-2" onclick="document.loginPage.command.value='loginCreate'" >Sign In</button>
					                    <input type="hidden" name="command">

					                </div>
                                </form>
                                <hr class="my-4">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	</form:form>
    <script src="/jquery/jquery-3.3.1.slim.min.js" type="text/javascript"></script>

    <script src="/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    <script src="js/custom.js" type="text/javascript"></script>

</body>


</html>