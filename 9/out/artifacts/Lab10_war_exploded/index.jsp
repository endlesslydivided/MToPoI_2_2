<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lab10</title>
    <style>
      .horizontal {
        display: inline-block;
        margin-right: 100px;
      }
    </style>
  </head>

  <body>
  <div class="horizontal">
    <img src="https://vk.com/sticker/1-81-128" style="margin: 10px">
    <form action="Time" method="GET">
      <input type="submit" value="Получить информацию">
    </form>
  </div>

  <div class="horizontal">
    <img src="https://pbs.twimg.com/media/Dg41IFQW4AA3Cm1.jpg:large" style="margin: 10px">
    <form method="POST" action="GoToLogin">
      <input type="submit" value="Окно авторизации"/>
    </form>
  </div>

  <div class="horizontal">
    <form method="GET" action="FirstServlet">
      <input type="submit" value="6"/>
    </form>
    <form method="POST" action="FirstServlet">
      <input type="submit" value="6"/>
    </form>
  </div>
  </body>
</html>
