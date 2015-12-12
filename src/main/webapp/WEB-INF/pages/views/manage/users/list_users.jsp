<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<c:if test="${!empty listUsers}">
  <div class="panel panel-default">
    <div class="panel-heading">Users</div>
        <table class="table">
            <tr>
              <th><spring:message code="label.email" /></th>
            </tr>
            <c:forEach items="${listUsers}" var="user">
                <c:if test="${user.username != 'admin'}">
                  <tr>
                    <td>${user.username}</td>
                    <td><a href="remove/${user.username}"><spring:message code="label.delete" /></a></td>
                  </tr>
                </c:if>
            </c:forEach>
      </table>
  </div>
  </c:if>
