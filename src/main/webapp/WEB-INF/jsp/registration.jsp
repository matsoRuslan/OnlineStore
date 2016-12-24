<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<c:url value='/resources/css/entry.css'/>" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <title>Registration</title>
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
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">OnlineStore</h1>
                <p>Registration</p>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center" id="form">
            <form:form class="form-horizontal" id="userform" action="registration" method="post" modelAttribute="user">
                <c:if test="${not empty submitDone}">
                    <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
                    <div class="alert alert-success">
                        <p>Registration successful.</p>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="firstname" class="cols-sm-2 control-label">Your Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="firstName" class="form-control myinput"
                                        placeholder="Enter your First Name"/>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input path="email" class="form-control myinput" placeholder="Enter your Email"/>
                            <form:errors path="email" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">Username</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="userName" class="form-control myinput" placeholder="Enter your Username"/>
                            <form:errors path="userName" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input type="password" path="password" class="form-control myinput"
                                        placeholder="Enter your Password"/>
                            <form:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input type="password" path="confirmPassword" class="form-control myinput"
                                        placeholder="Confirm your Password"/>
                            <form:errors path="confirmPassword" cssClass="error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
                </div>
                <div class="login-register">
                    <a href="/home/login">Sign in</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/registration.js'/>"></script>
</body>
</html>