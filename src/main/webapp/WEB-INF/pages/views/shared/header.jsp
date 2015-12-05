<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

    <%--<div class="navbar navbar-inverse navbar-fixed-top">--%>
        <%--<div class="container">--%>
                <%--<th> </th>--%>
                <%--<th><a href="/register">Register</a> </th></tr>&nbsp;--%>
                <%--<c:if test="${user != 'guest'}">--%>
                    <%--<th><a href="<c:url value="/logout" />" > Logout</a></th>--%>
                    <%--<th><a href="<c:url value="/manage" />" style="color: darkred">${user}</a></th>--%>
                <%--</c:if>--%>
            <%--</tr>--%>
            <%--</thead>--%>
        <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>


<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test = "${user == 'guest'}">
                    <li><a href="<c:url value="/login.jsp"/>">Log In</a> </li>
                </c:if>
                <c:if test="${user != 'guest' && user != null}">
                    <li><a href="<c:url value="/manage" />">${user}</a></li>
                    <li><a href="<c:url value="/logout" />">Log Out</a></li>
                </c:if>
            </ul>

        </div>
    </div>
</div>


