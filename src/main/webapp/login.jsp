<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<h1>Log In</h1>
<h4>Use a local account to log in.</h4>
<hr />

<c:if test="${not empty param.error}">
    <font color="red"> Login error
        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check"/>" class="form-horizontal">
    <div class="form-group">
        <label for="username" class="col-md-2 control-label">Email</label>
        <div class="col-md-4">
            <input id="username" type="text" name="j_username" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-md-2 control-label">Password</label>
        <div class="col-md-4">
            <input id="password" type="password" name="j_password" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="rememberMe" class="col-md-2 control-label">Remember Me</label>
        <div class="col-md-10"><input id="rememberMe" type="checkbox" name="j_spring_security_remember_me" /></div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" value="Login" class="btn btn-success"/>
            <input type="reset" value="Reset" class="btn btn-default"/>
        </div>
    </div>
</form>
<p>
    <a href="/register" type="button">Register as a new User</a>
</p>