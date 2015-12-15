<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<a href="/create_book">Add new Book</a>
</br>
</br>
<c:if test="${!empty listBook}">
    <div class="panel panel-default">
        <div class="panel-heading">Books</div>
        <table class="table">
            <tr>
                <th><spring:message code="label.title" /></th>
                <th>&nbsp;&nbsp;</th>
                <th><spring:message code="label.description" /></th>
                <th>&nbsp;&nbsp;</th>
                <th><spring:message code="label.isbn" /></th>
                <th>&nbsp;&nbsp;</th>
            </tr>
            <c:forEach items="${listBook}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <th>&nbsp;&nbsp;</th>
                    <td>${book.description}</td>
                    <th>&nbsp;&nbsp;</th>
                    <td>${book.isbn}</td>
                    <th>&nbsp;&nbsp;</th>
                    <td><a href="delete/${book.bookId}"><spring:message code="label.delete" /></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
