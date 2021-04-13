<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Lab10</title>
    <style>
      .horizontal {
        display: inline-block;
        margin-right: 100px;
      }

      input {
        width: 300px;
        font-size: 13px;
        padding: 6px 0 4px 10px;
        border: 1px solid #cecece;
        background: #F6F6f6;
        border-radius: 8px;
      }
    </style>
  </head>

  <body>
  <div >
    <form action="Time" method="GET">
      <input type="submit"  style="" value="Получить информацию">
    </form>
  </div>

  <div >
    <form method="POST" action="GoToLogin">
      <input type="submit"   style="" value="Окно авторизации">
      </input>
    </form>
  </div>

  <div>
    <form method="GET" action="FirstServlet">
      <input type="submit"  style="" value="GET"/>
    </form>
    <form method="POST" action="FirstServlet">
      <input type="submit"  style="" value="POST"/>
    </form>
  </div>
  </body>
</html>
