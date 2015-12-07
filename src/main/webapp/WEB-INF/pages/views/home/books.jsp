<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<h2>Books</h2>
<h4>This is view all books in OnlineLibrary</h4>
<hr/>
<%--<c:if test="${!empty listBook}">--%>
  <%--<table class="data">--%>
    <%--<tr>--%>
      <%--<th><spring:message code="label.title" /></th>--%>
      <%--<th><spring:message code="label.description" /></th>--%>
      <%--<th><spring:message code="label.isbn" /></th>--%>
      <%--<th>&nbsp;</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${listBook}" var="book">--%>
      <%--<tr>--%>
        <%--<td>${book.title}, ${book.name}</td>--%>
        <%--<td>${book.description}</td>--%>
        <%--<td>${book.isbn}</td>--%>
        <%--<c:if test="${book.isAvailable()}">--%>
          <%--<td><a href="get/${book.id}"><spring:message code="label.getbook" /></a></td>--%>
        <%--</c:if>--%>
        <%--<c:if test="${!book.isAvailable()}">--%>
          <%--<td><a href="return/${book.id}"><spring:message code="label.returnbook" /></a></td>--%>
        <%--</c:if>--%>
        <%--<td><a href="delete/${book.id}"><spring:message code="label.delete" /></a></td>--%>
      <%--</tr>--%>
    <%--</c:forEach>--%>
  <%--</table>--%>
<%--</c:if>--%>




<c:if test="${!empty listBook}">

  <div class="row">
  <c:forEach items="${listBook}" var="book">
      <div class="col-sm-4 col-md-3">
        <div class="thumbnail">
          <img src="resources/images/bookDefault.png" alt="Cover">
          <div class="caption">
            <h3>${book.title}</h3>
            <p>${book.description}</p>
            <p>
              <c:if test="${book.isAvailable()}">
                <a href="get/${book.id}" class="btn btn-primary" role="button"><spring:message code="label.getbook" /></a>
              </c:if>
              <c:if test="${!book.isAvailable()}">
                <a href="return/${book.id}" class="btn btn-primary" role="button"><spring:message code="label.returnbook" /></a>
              </c:if>
              <a href="delete/${book.id}" class="btn btn-danger" role="button"><spring:message code="label.delete" /></a>
            </p>
          </div>
        </div>
      </div>
  </c:forEach>
  </div>
</c:if>
