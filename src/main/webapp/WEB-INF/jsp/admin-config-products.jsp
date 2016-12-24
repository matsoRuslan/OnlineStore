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
<script>var page = '${page}';</script>
<script>var size = '${size}';</script>
<script>var pageCount = '${pageCount}';</script>
<script>var totalSize = '${totalSize}';</script>
<script>var productSearch = '${productSearch}';</script>
<div class="panel-title text-center">
    <h2 class="title">Configurations</h2>
</div>
<ul class="nav nav-pills">
    <li role="presentation"><a href="/home/admin-config/edit-users">Edit users</a></li>
    <li role="presentation"><a href="/home/admin-config/edit-categories">Edit categories</a></li>
    <li role="presentation" class="active"><a id="edit-items">Edit items</a></li>
</ul>
<div class="well">
    <div class="input-group pull-left" style="width: 300px">
        <input type="text" id="search-input2" class="form-control" placeholder="Search"/>
        <a type="submit" class="btn btn-danger input-group-addon" id="search2"><span class="glyphicon glyphicon-search"
                                                                                     aria-hidden="true"></span></a>
    </div>

    <div class="dropdown col-md-offset-10">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="true">
            Items per page
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a id="allHref">All</a></li>
            <li><a href="/home/admin-config/edit-products-paging?size=3&page=1">3</a></li>
            <li><a href="/home/admin-config/edit-products-paging?size=6&page=1">6</a></li>
            <li><a href="/home/admin-config/edit-products-paging?size=18&page=1">18</a></li>
            <li><a href="/home//admin-config/edit-products-paging?size=30&page=1">30</a></li>
        </ul>
    </div>

    <ul class="pagination pull-right" id="paging">
    </ul>
    <div class="text-center">
        <a class="btn btn-primary col-md-offset-1" href="/home/admin-config/adm-add-product">Add item</a>
    </div>

    <table class="table">
        <thead>

        <tr>
            <th>#</th>
            <th>Image</th>
            <th>Title</th>
            <th>Short description</th>
            <th>Full description</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Category</th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody id="table-body">
        <th class="panel-title text-center">
            <h3 class="title" id="items"></h3>
        </th>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div id="modals">
</div>


</body>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>

<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/admin-config-products.js'/>"></script>
</html>