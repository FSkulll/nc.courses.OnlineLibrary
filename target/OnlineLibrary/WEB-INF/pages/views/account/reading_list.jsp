<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
</br>
</br>
<c:if test="${!empty listIssue}">
  <div class="panel panel-default">
    <div class="panel-heading">Books</div>
    <table class="table">
      <tr>
        <th><spring:message code="label.title" /></th>
        <th>&nbsp;&nbsp;</th>
        <th><spring:message code="label.dateofissue" /></th>
        <th>&nbsp;&nbsp;</th>
        <th><spring:message code="label.dateofreturn" /></th>
        <th>&nbsp;&nbsp;</th>
      </tr>
      <c:forEach items="${listIssue}" var="issue">
        <tr>
          <td>${issue.getReadBook().getTitle()}</td>
          <th>&nbsp;&nbsp;</th>
          <td>${issue.dateOfIssue}</td>
          <th>&nbsp;&nbsp;</th>
          <td>${issue.dateOfReturn}</td>
          <th>&nbsp;&nbsp;</th>
          <c:if test="${issue.dateOfReturn == null}">
            <td><a href="return/${issue.getReadBook().getBookId()}"><spring:message code="label.returnbook" /></a></td>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
