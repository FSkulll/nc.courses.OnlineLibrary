<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>


<h1>REGISTER PAGE</h1>
<form:form method="post" action="create" commandName="user">

    <table>
        <tr>
            <td><form:label path="username">
                <spring:message code="label.email" />
            </form:label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><form:label path="password">
                <spring:message code="label.password" />
            </form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.register"/>" />
        </td>
        </tr>
    </table>
</form:form>