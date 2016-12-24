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

    <title>Add category</title>
</head>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
</sec:authorize>
<div class="container" style="max-width: 970px;">
    <div class="panel-title text-center">
        <h1 class="title">Add category</h1>
    </div>
    <form:form class="form-horizontal" id="categoryaddform" action="${window.location.pathname}" method="post"
               modelAttribute="category">
        <c:if test="${not empty submitDone}">
            <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
            <div class="alert alert-success">
                <p>Category was successfully added.</p>
            </div>
        </c:if>
        <c:if test="${not empty submitNotDone}">
            <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
            <div class="alert alert-danger">
                <p>Invalid input.</p>
            </div>
        </c:if>
        <form:hidden path="parent.id"/>
        <form:hidden path="parent.hasChildren"/>
        <div class="input-group">
            <span class="input-group-addon">Title</span>
            <form:input path="title" class="form-control myinput" placeholder="Enter title"/>
            <form:errors path="title" cssClass="error"/>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Parent Category</span>
            <form:input path="parent.title" class="form-control myinput"
                        placeholder="Enter parent title. Leave empty if category has no parent"/>
            <form:errors path="parent.title" cssClass="error"/>
        </div>
        <br>
        <div>
            <button class="btn btn-primary col-md-offset-6" type="submit">Create</button>
        </div>
    </form:form>


</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
