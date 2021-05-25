<%--
  Created by IntelliJ IDEA.
  User: ON
  Date: 24.05.2021
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<div class="navbar-collapse">
    <ul class="nav navbar-nav">
        <li class="active"><a href="#"></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/controller?command=login_page">Вход</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Выход</a></li>
    </ul>
</div>
</nav>
<div class="container">
    <H3>Добрый день, ${username}</H3>
    <caption>Список вашей группы</caption>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Телефон</th>
            <th>email</th>
        </tr>
        <c:forEach items="${group}" var="person">
            <tr><td>${person.name}</td>
                <td>${person.phone}</td>
                <td>${person.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p><font color="red">${errorMessage}</font></p>
    <form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=add_new_person">
        Новый :
        <p> Введите имя <input name="nname" type="text" /> </p>
        <p> Введите телефон <input name="nphone" type="text" /> </p>
        <p> Введите email <input name="nemail" type="text" /> </p>
        <input class ="button-main-page" value="Добавить" type="submit" />
    </form>
</div>
<p> ${lastdate}</p>
</body>
</html>
