<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>CORE TAGS</h1>
<p><c:out value="${message}" default="Привет мир!" /></p><br/>
<c:set var="Income" scope="session" value="${4000*4}"/>
<c:out value="${Income}"/><br/>
<c:set var="income" scope="session" value="${4000*4}"/>
<p>Before Remove Value is: <c:out value="${income}"/></p>
<c:remove var="income"/>
<p>After Remove Value is: <c:out value="${income}"/></p><br/>

<c:set var = "salary" scope = "session" value = "${2000*2}"/>
<c:if test = "${salary > 2000}">
<p>My salary is:  <c:out value = "${salary}"/><p>
    </c:if>
<br/>
<form action="core.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="Core"/>
</form>
<form action="formatting.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="Formatting"/>
</form>
<form action="functions.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="Functions"/>
</form>
<form action="sql.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="Sql"/>
</form>
<form action="xml.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="Xml"/>
</form>



<form action="table.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-success mx-auto" value="my table"/>
</form>
</body>
</html>