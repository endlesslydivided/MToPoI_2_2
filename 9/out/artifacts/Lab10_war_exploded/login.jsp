<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorize</title>
    </head>
<body>
<fieldset>
    <legend>Authorize</legend>
    <form action="Login" method="POST">
        <input name="login" type="text" placeholder="login"/>
        <input name="password" type="text" placeholder="password"/>
        <input type="submit" value="Войти"/>
    </form>
</fieldset>
    <form action="GoToRegister" method="POST">
        <input type="submit" value="Регистрация"/>
    </form>
</body>
</html>
