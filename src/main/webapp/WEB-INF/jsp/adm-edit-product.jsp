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

    <title>Edit item</title>
</head>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/jsp/navbar-admin.jsp"/>
</sec:authorize>
<script>var totalSize = '${totalSize}';</script>
<script>var productId = <c:out value="${productId}"/> </script>
<div class="container" style="max-width: 970px;">
    <div class="panel-title text-center">
        <h1 class="title">Edit item</h1>
    </div>
    <c:if test="${not empty cteated}">
        <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
        <div class="alert alert-success">
            <p>Item was successfully edited.</p>
        </div>
    </c:if>
    <c:if test="${not empty submitDone}">
        <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
        <div class="alert alert-success">
            <p>Item was successfully edited.</p>
        </div>
    </c:if>
    <c:if test="${not empty submitNotDone}">
        <input type="hidden" id="modelAttr" name="modelAttr" value="${submitDone}"/>
        <div class="alert alert-danger">
            <p>Invalid input.</p>
        </div>
    </c:if>
    <c:if test="${not empty cteated}">
        <div id="product-image" class="text-center">
                <%--prodcut image--%>
        </div>
        <br>
        <form:form class="form-horizontal" id="productaddimage" action="${window.location.pathname}" method="post"
                   modelAttribute="fileBucket" enctype="multipart/form-data">
            <div class="input-group col-lg-offset-3">
                <span class="input-group-addon" for="filebutton">Edit image</span>
                <div class="col-md-4">
                    <form:input path="file" id="filebutton" name="filebutton" class="input-file btn btn-primary "
                                type="file"/>
                </div>
            </div>
            <br>

            <div>
                <button class="btn btn-primary col-md-offset-5" type="submit" id="createButton">Edit</button>
                <a class="btn btn-danger" id="close-tab">Close</a>
            </div>

        </form:form>
    </c:if>
    <c:if test="${empty cteated}">
        <form:form class="form-horizontal" id="productaddform" action="${window.location.pathname}" method="post"
                   modelAttribute="product">
            <form:hidden path="id"/>
            <form:hidden path="active"/>
            <form:hidden path="image.id"/>
            <div class="input-group">
                <span class="input-group-addon">Title</span>
                <form:input path="title" class="form-control myinput" placeholder="Enter title"/>
                <form:errors path="title" cssClass="error"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Description</span>
                <form:input path="description" class="form-control myinput" placeholder="Enter short description"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Full description</span>
                <form:textarea path="fullDescription" class="form-control myinput" rows="5"
                               placeholder="Enter full description"/>
                <form:errors path="fullDescription" cssClass="error"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Price</span>
                <form:input path="price" class="form-control myinput" placeholder="Enter item price"/>
                <form:errors path="price" cssClass="error"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Amount</span>
                <form:input path="amount" class="form-control myinput" placeholder="Enter item amount"/>
                <form:errors path="amount" cssClass="error"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Category</span>
                <form:input path="category.title" class="form-control myinput" placeholder="Enter item category"/>
                <form:errors path="category.title" cssClass="error"/>
            </div>
            <br>
            <c:if test="${empty cteated}">
                <div>
                    <button class="btn btn-primary col-md-offset-6" type="submit">Edit</button>
                </div>
            </c:if>
        </form:form>
    </c:if>


</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/adm-edit-product.js'/>"></script>
</body>
