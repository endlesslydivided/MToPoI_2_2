<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Formatting</title>
</head>
<body>
    <h4>Работа с датами</h4>
        <jsp:useBean id="now" class="java.util.Date" />
        <fmt:setLocale value="en-EN"/>
        Вывод даты в формате English<br/>
        Сегодня: <fmt:formatDate value="${now}" /><br/>
        <fmt:setLocale value="ru-RU"/>
        Вывод даты в формате Russian<br/>
        Сегодня: <fmt:formatDate value="${now}" /><br/>
        Стиль времени:
        (short): <fmt:formatDate value="${now}"
                                 type="time" timeStyle="short" /><br/>
        (medium):<fmt:formatDate value="${now}"
                                 type="time" timeStyle="medium" /><br/>
        (long): <fmt:formatDate value="${now}"
                                type="time" timeStyle="long" /><br/><br/>
    <h4>Перевод чисел</h4>
        <c:set var="currentNumber" value="125"/>
        <c:out value="Вывод формата числа : ${currentNumber}"/> <br/>
        Формат :
        <fmt:formatNumber value="${currentNumber}" /><br/>
        Процентный формат :
        <fmt:formatNumber value="${currentNumber}"
                          type="percent"/><br/>
        <fmt:setLocale value="be-BY"/>
        Белорусские рубли :
        <fmt:formatNumber value="${currentNumber}"
                          type="currency"/><br/>
        Американская валюта :
        <fmt:setLocale value="en-US"/>
        <fmt:formatNumber value= "${currentNumber}" type="currency"/><br/>
</body>
</html>
