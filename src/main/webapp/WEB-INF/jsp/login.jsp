<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<c:url value='/resources/css/entry.css'/>" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <title>Login</title>
</head>
<sec:authorize access="isAnonymous()">
    <body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <div class="row main">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h1 class="title">OnlineStore</h1>
                    <p>Sign in</p>
                    <hr/>
                </div>
            </div>
            <div class="main-login main-center">
                <c:url var="loginUrl" value="/login"/>
                <form class="form-horizontal" method="post" action="${loginUrl}">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="userName" id="userName"
                                       placeholder="Enter your Username"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg"
                                                                   aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign in</button>
                    </div>
                    <div class="login-register">
                        <a href="/home/registration">Create account</a>
                    </div>
                </form>

            </div>
        </div>
    </div>

    </body>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    <body>
    <jsp:include page="/WEB-INF/jsp/navbar-user.jsp"/>
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="title">You already are authorized</h1>
        </div>
    </div>
    </body>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <body>
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="title">You already are authorized</h1>
        </div>
    </div>
    </body>
</sec:authorize>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</html>