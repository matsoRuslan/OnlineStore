<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/entry.css'/>" rel="stylesheet">
    <title>Configuration</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
<script>var totalSize = '${totalSize}';</script>
<div class="panel-title text-center">
    <h2 class="title">Configurations</h2>
</div>
<ul class="nav nav-pills">
    <li role="presentation" class="active"><a href="/home/admin-config/edit-users">Edit users</a></li>
    <li role="presentation"><a href="/home/admin-config/edit-categories">Edit categories</a></li>
    <li role="presentation"><a id="edit-items">Edit items</a></li>
</ul>
<div class="well">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone number</th>
            <th>Address</th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody id="table-body">
        </tbody>
    </table>
</div>


</body>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>

<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/admin-config-users.js'/>"></script>
</html>