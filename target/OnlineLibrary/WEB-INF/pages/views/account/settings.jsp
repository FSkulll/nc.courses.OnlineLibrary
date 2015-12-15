<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>MANAGE PAGE</h1>
<form:form method="post" action="edit" commandName="user">

  <table>
    <tr>
      <td><form:label path="username">
        <spring:message code="label.email" />
      </form:label></td>
      <td><form:input path="username"/></td>
    </tr>
    <tr>
      <td><form:label path="password">
        <spring:message code="label.password" />
      </form:label></td>
      <td><form:input path="password" type="password"/></td>
    </tr>
    <tr>
      <td><form:label path="password">
        <spring:message code="label.confpass" />
      </form:label></td>
      <td><form:input path="password" type="password"/></td>
    </tr>
    <td colspan="2">
      <input type="submit" value="<spring:message code="label.edit"/>" />
    </td>
    </tr>
  </table>
</form:form>
