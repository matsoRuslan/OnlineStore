<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3">
    <p class="lead">Categories</p>
    <div class="btn-group-vertical" role="group" id="category-buttons">
        <button class="btn btn-default " type="button" aria-haspopup="true" aria-expanded="true"><a
                href="/home/" style="text-decoration: none; color: black">All</a></button>
    </div>
</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/sidebar.js'/>"></script>