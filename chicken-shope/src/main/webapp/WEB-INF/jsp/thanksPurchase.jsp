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

    <link rel="icon" type="image/png" href="img/Logo/Final logo-02.png">

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="vendor/fontawesome/css/all.min.css" rel="stylesheet">

    <link href="vendor/icofont/icofont.min.css" rel="stylesheet">

    <link href="vendor/select2/css/select2.min.css" rel="stylesheet">

    <link href="css/maizil.css" rel="stylesheet">
</head>

<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form:form name="eclgsOffer" id="porto" commoandName="eclgsOffer" modelAttribute="eclgsOffer" action="" method="post">
    <jsp:include page="header.jsp" />
    <section class="section pt-5 pb-5 maizil-not-found-page">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center pt-5 pb-5">
                    <img class="img-fluid mb-5" src="img/thanks.png" alt="404">
                    <h1 class="mt-2 mb-2 text-success">Congratulations!</h1>
                    <p class="mb-5">You have successfully placed your order</p>
                    <a class="btn btn-primary btn-lg" href="/purchaseOrderList">View Order :)</a>
                </div>
            </div>
        </div>
    </section>
  

       <jsp:include page="footer.jsp" />

    </form:form>

    <script src="vendor/jquery/jquery-3.3.1.slim.min.js" type="3c64a63abdff8bf1acee0855-text/javascript"></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="3c64a63abdff8bf1acee0855-text/javascript"></script>

    <script src="vendor/select2/js/select2.min.js" type="3c64a63abdff8bf1acee0855-text/javascript"></script>

    <script src="js/custom.js" type="3c64a63abdff8bf1acee0855-text/javascript"></script>
</body>

</html>