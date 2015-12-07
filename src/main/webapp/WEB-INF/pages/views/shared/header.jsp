<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">Library</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">Home</a></li>
                <li><a href="/books">Books</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${username == 'admin'}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/books_list">Books</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/users_list">Users</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Categories</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test = "${username == 'guest' || user == null || username == null}">
                    <li><a href="<c:url value="/login"/>">Log In</a> </li>
                </c:if>
                <c:if test="${username != 'guest' && user != null && username != null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hello, ${username}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">My List</a></li>
                            <li><a href="<c:url value="/manage" />">Settings</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<c:url value="/logout" />">Log Out</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>

        </div>
    </div>
</div>


