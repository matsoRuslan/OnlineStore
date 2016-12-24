<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value='/resources/css/navbar.css'/>" rel="stylesheet">
<div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar-collapse-3">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/home/">OnlineShop</a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse-3">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="btn btn-inverse btn-outline btn-circle" data-toggle="collapse" href="#nav-collapse3"
                           aria-expanded="false" aria-controls="nav-collapse3">Search</a>
                    </li>
                    <li><a href="/home/cart">Cart</a></li>
                    <li><a href="/home/profile">Profile info</a></li>
                    <li><a href="/home/logout">Log out</a></li>
                </ul>
                <div class="collapse nav navbar-nav nav-collapse" id="nav-collapse3">
                    <div class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" id="search-input" class="form-control" placeholder="Search"/>
                        </div>
                        <a type="submit" class="btn btn-danger" id="search"><span class="glyphicon glyphicon-search"
                                                                                  aria-hidden="true"></span></a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>
<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/navbar.js'/>"></script>