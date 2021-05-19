<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="background: linear-gradient(45deg,blueviolet,royalblue); background-size: cover; background-attachment: fixed; backdrop-filter: blur(3px)">
<h1 style="text-align: center;font-family: 'Samsung Sharp Sans'">Основные теги</h1>
<p style="font-family: 'SamsungOne 400'"><c:out value="${message}" default="Привет мир!" /></p>
<c:set var="Income" scope="session" value="${4000*4}"/>
<p style="font-family: 'SamsungOne 400'"><c:out  value="${Income}"/></p>
<c:set var="income" scope="session" value="${4000*4}"/>
<p style="font-family: 'SamsungOne 400'">До Remove значение: <c:out value="${income}"/></p>
<c:remove var="income"/>
<p style="font-family: 'SamsungOne 400'">После Remove значение : <c:out value="${income}"/></p>

<c:set var = "salary" scope = "session" value = "${8.8}"/>
<c:if test = "${salary <= 10}">
<p style="font-family: 'SamsungOne 400'">Моя средняя оценка:  <c:out value = "${salary}"/><p>
    </c:if>
<br/>
<form style="font-family: 'SamsungOne 400'" action="core.jsp" method="POST" class="vertical">
    <input style="font-family: 'SamsungOne 400'" type="submit" class="btn btn-success mx-auto" value="Core"/>
</form>
<form style="font-family: 'SamsungOne 400'" action="formatting.jsp" method="POST" class="vertical">
    <input style="font-family: 'SamsungOne 400'" type="submit" class="btn btn-success mx-auto" value="Formatting"/>
</form>
<form style="font-family: 'SamsungOne 400'" action="functions.jsp" method="POST" class="vertical">
    <input style="font-family: 'SamsungOne 400'" type="submit" class="btn btn-success mx-auto" value="Functions"/>
</form>

<form style="font-family: 'SamsungOne 400'" action="xml.jsp" method="POST" class="vertical">
    <input style="font-family: 'SamsungOne 400'" type="submit" class="btn btn-success mx-auto" value="Xml"/>
</form>
<form style="font-family: 'SamsungOne 400'" action="table.jsp" method="POST" class="vertical">
    <input style="font-family: 'SamsungOne 400'" type="submit" class="btn btn-success mx-auto" value="My table"/>
</form>
</body>
</html>