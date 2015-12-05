<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Log in</title>
</head>
<body>

<h1>LOGIN PAGE</h1>

<a href="<c:url value="/index" />">
    Users
</a><br/>

<c:if test="${not empty param.error}">
    <font color="red"> Login error
        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
    <table>
        <tr>
            <td align="right">Login</td>
            <td><input type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input type="password" name="j_password" /></td>
        </tr>
        <tr>
            <td align="right">Remember me</td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Login" />
                <input type="reset" value="Reset" /></td>
        </tr>
    </table>
</form>
<h2>If you don't have account. You may register</h2>
<a href="/register" type="button">Register</a>
</body>
</html>