<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<c:url value='/resources/css/entry.css'/>" rel="stylesheet">
    <title>Item not available</title>
</head>
<body>
<sec:authorize access="hasRole('USER')">
    <jsp:include page="/WEB-INF/jsp/navbar-user.jsp" />
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp" />
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <jsp:include page="/WEB-INF/jsp/navbar.jsp" />
</sec:authorize>
<div class="panel-heading">
    <div class="panel-title text-center">
        <h3 class="title">Dear <strong>${user}</strong>, this item is no longer available</h3>
    </div>
</div>
</body>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>

<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</html>