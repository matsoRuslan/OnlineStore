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

    <title>Edit user</title>
</head>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
</sec:authorize>
<div class="container" style="max-width: 970px;">
    <div class="panel-title text-center">
        <h1 class="title">Edit user</h1>
    </div>
    <form:form class="form-horizontal" id="categoryform" action="${window.location.pathname}" method="post"
               modelAttribute="user">
        <c:if test="${not empty submitDone}">
            <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
            <div class="alert alert-success">
                <p>Update successful.</p>
            </div>
        </c:if>
        <c:if test="${not empty submitNotDone}">
            <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
            <div class="alert alert-danger">
                <p>Invalid input.</p>
            </div>
        </c:if>
        <form:hidden path="id"/>
        <form:hidden path="password"/>
        <form:hidden path="active"/>
        <div class="input-group">
            <span class="input-group-addon">First name</span>
            <form:input path="firstName" class="form-control myinput" placeholder="Enter your First name"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Last name</span>
            <form:input path="lastName" class="form-control myinput" placeholder="Enter your Last nme"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Username</span>
            <form:input path="userName" class="form-control myinput" placeholder="Enter your Username"/>
            <form:errors path="userName" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Email</span>
            <form:input path="email" class="form-control myinput" placeholder="Enter your Email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Phone number</span>
            <form:input path="phoneNumber" class="form-control myinput" placeholder="Enter your Phone number"/>
            <form:errors path="phoneNumber" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Address</span>
            <form:input path="Address" class="form-control myinput" placeholder="Enter your Address"/>
            <form:errors path="Address" cssClass="error"/>
        </div>
        <br>
        <div>
            <button class="btn btn-primary col-md-offset-6" type="submit">Update</button>
        </div>
    </form:form>


</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>