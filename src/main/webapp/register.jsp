<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<h1>Register.</h1>
<h4>Create a new account.</h4>
<hr />
<form:form method="post" action="create" commandName="user" cssClass="form-horizontal">
        <div class="form-group">
            <form:label path="username" cssClass="col-md-2 control-label">
                <spring:message code="label.email" />
            </form:label>
            <div class="col-md-4"><form:input path="username" cssClass="form-control"/></div>
        </div>
        <div class="form-group">
            <form:label path="password" cssClass="col-md-2 control-label">
                <spring:message code="label.password" />
            </form:label>
            <div class="col-md-4"><form:input path="password" cssClass="form-control"/></div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <input type="submit" class="btn btn-default" value="<spring:message code="label.register"/>" />
            </div>
        </div>
</form:form>