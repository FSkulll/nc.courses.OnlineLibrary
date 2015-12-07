<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<h2>Books</h2>
<h4>You may to add a new book</h4>
<hr/>

<form:form method="get" action="add" commandName="book" class="form-horizontal">
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <form:label path="title" class = "col-md-2 control-label" >
          <spring:message code="label.title" />
        </form:label>
        <div class="col-md-10" >
          <form:input path="title" class = "form-control" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="description" class = "col-md-2 control-label" >
          <spring:message code="label.description" />
        </form:label>
        <div class="col-md-10" >
          <form:input path="description" class = "form-control" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="name" class = "col-md-2 control-label" >
          <spring:message code="label.name" />
        </form:label>
        <div class="col-md-10" >
          <form:input path="name" class = "form-control" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="isbn" class = "col-md-2 control-label" >
          <spring:message code="label.isbn" />
        </form:label>
        <div class="col-md-10" >
          <form:input path="isbn" class = "form-control" />
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
          <input type="submit" value="<spring:message code="label.addbook"/>" class="btn btn-default" />
        </div>
      </div>
    </div>
  </div>
</form:form>
