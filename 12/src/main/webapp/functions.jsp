<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Function</title>
</head>
<body>
    <c:set var="string" value="Java!"/>

    <c:if test="${fn:contains(string, 'java')}">
        Cтрока содержитж java
    </c:if>
    <br/>

    <c:if test = "${fn:containsIgnoreCase(string, 'a')}">
        Строка содержит a (IgnoreCase)<br/><br/>
    </c:if>

    <c:if test = "${fn:endsWith(string, 'a')}">
        Строка заканчивается на a<br/><br/>
    </c:if>

    <c:set var = "string1" value = "Это первая строка."/>
    <c:set var = "string2" value = "Это <abc>вторая строка.</abc>"/>
    Индекс (1) : ${fn:indexOf(string1, "строка")}<br/>
    Индекс (2) : ${fn:indexOf(string2, "вторая")}<br/><br/>

    <c:set var = "string1" value = "Это первая строка."/>
    <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
    <c:set var = "string3" value = "${fn:join(string2, '-')}" />
    ${string3}<br/><br/>

    <c:set var = "string1" value = "Это первая строка."/>
    Длина строки  String1 : ${fn:length(string1)}<br/><br/>

    <c:set var = "string1" value = "Это первая строка."/>
    <c:set var = "string2" value = "${fn:replace(string1, 'first', 'second')}" />
    ${string2}<br>
</body>
</html>
