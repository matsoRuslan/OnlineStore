<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Category</title>

    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<c:url value='/resources/css/shop-homepage.css'/>" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>

<body>
<sec:authorize access="hasRole('USER')">
    <jsp:include page="/WEB-INF/jsp/navbar-user.jsp"/>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <jsp:include page="/WEB-INF/jsp/navbar.jsp"/>
</sec:authorize>


<div class="container">

    <div class="row">

        <jsp:include page="/WEB-INF/jsp/sidebar.jsp"/>

        <div class="col-md-9">

            <div class="row carousel-holder">


            </div>

            <div class="row products">
                <div class="panel-title text-center">
                    <h3 class="title" id="category"></h3>
                </div>
            </div>


        </div>

    </div>

</div>

</div>

<div class="container">

    <hr>

    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy;Skillerone 2016</p>
            </div>
        </div>
    </footer>

</div>

<script src="<c:url value='/resources/js/jquery.js'/>"></script>

<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>


<script src="<c:url value='/resources/js/category.js'/>"></script>

</body>

</html>

