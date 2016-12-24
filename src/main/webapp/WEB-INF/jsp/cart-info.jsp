<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/css/shop-homepage.css'/>" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <title>Cart info</title>
</head>
<body>
<sec:authorize access="hasRole('USER')">
    <jsp:include page="/WEB-INF/jsp/navbar-user.jsp"/>
</sec:authorize>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<script>var cartId =
<c:out value="${cartID}"/> </script>
<div class="panel-title text-center">
    <h1 class="title">Cart</h1>

</div>
<input type="hidden" id="modelAttr" name="modelAttr" value="${cart}"/>
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-md-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <form:form class="form-horizontal" id="userprofileform" action="/home/shipping-address"
                               method="post"
                               modelAttribute="cart">
                        <form:hidden path="id"/>
                        <div class="input-group">
                            <span class="input-group-addon">Shipping address</span>
                            <form:input path="shippingAddress" class="form-control myinput"
                                        placeholder="Enter your Shipping address"/>
                            <form:errors path="shippingAddress" cssClass="error"/>
                            <div class="input-group-btn">
                                <button class="btn btn-primary" type="submit">Update</button>
                            </div>
                        </div>

                    </form:form>
                </div>
                <div class="panel-body">
                    <div class="row products">
                        <div class="panel-title text-center">
                            <h3 class="title" id="cart"></h3>
                        </div>
                        <%--div for product list--%>
                    </div>
                </div>
                <div class="panel-footer">
                    <div class="row text-center">
                        <div class="col-xs-8">
                            <h4 class="text-right" id="total-price"></h4>
                        </div>
                        <div class="col-xs-3">
                            <button type="button" id="modal-product-button" class="btn btn-primary btn-block">
                                Recently bought products
                            </button>
                        </div>

                        <!-- Modal -->
                        <div id="myModal" class="modal fade" role="dialog">
                            <div class="modal-dialog">

                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Recently bought products</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row modal-products">
                                            <div class="panel-title text-center">
                                                <h3 class="title" id="recent"></h3>
                                            </div>
                                            <%--div for modal product list--%>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/fill-cart.js'/>"></script>
</body>