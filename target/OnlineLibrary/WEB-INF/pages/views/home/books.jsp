<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<h2>Books</h2>
<h4>This is view all books in OnlineLibrary</h4>
<hr/>


<c:if test="${!empty listBook}">

  <div class="row">
  <c:forEach items="${listBook}" var="book">
      <div class="col-sm-4 col-md-3">
        <div class="thumbnail">
          <img src="/resources/images/bookDefault.png" alt="Cover">
          <div class="caption">
            <h3>${book.title}</h3>
            <p>${book.description}</p>
            <p>
              <c:if test="${book.getAvailable()}">
                <a href="get/${book.bookId}" class="btn btn-primary" role="button"><spring:message code="label.getbook" /></a>
              </c:if>
              <c:if test="${!book.getAvailable() && book.getOwner() == username}">
                <a href="return/${book.bookId}" class="btn btn-primary" role="button"><spring:message code="label.returnbook" /></a>
              </c:if>
              <c:if test="${!book.getAvailable() && book.getOwner() != username}">
                <label class="text text-danger"><spring:message code="label.available" /></label>
              </c:if>
              <a href="/show/${book.bookId}" class="btn btn-default" role="button"><spring:message code="label.more" /></a>
            </p>
          </div>
        </div>
      </div>
  </c:forEach>
  </div>
</c:if>
