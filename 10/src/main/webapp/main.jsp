<%--
  Created by IntelliJ IDEA.
  User: ON
  Date: 15.04.2021
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="DB.DBConnector" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src = "http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>Главная страница</title>
    <style>
        .vertical {
            display: block;
            margin-top: 5px;
            horiz-align: center;
        }
         body,html {
             height: 100%;
         }
    </style>
    </style>
</head>
<body>
<h3>Команда:</h3>
<table class="table table-striped table-bordered table-condensed table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Номер игрока</th>
        <th>ФИО</th>
    </tr>
    </thead>
    <tbody>
<%
    DBConnector connection = new DBConnector();
    try {
        connection.SetConnection();
        ResultSet queryResult = connection.ExecuteQuery("SELECT * FROM PLAYERS");
        while(queryResult.next()) {
%>
    <tr>
        <td> <%= queryResult.getString("id") %> </td>
        <td> <%= queryResult.getString("number")%> </td>
        <td> <%= queryResult.getString("fullName")%>  </td>
    </tr>
<%
        }
    }catch (Exception e){
        System.out.println(e);
    }
%>

    </tbody>
</table>
<div class="col-sm-5 col-md-5 col-lg-5 col-5 col-xl-5 mx-auto">

<div class="card border-secondary mb-3 p-3" >
<form action="AddPlayer.jsp" method="POST"  class="vertical">
    <input type="submit" class="btn btn-info mx-auto" value="Добавить игрока в команду"/>
</form>
<form action="DeletePlayer.jsp" method="POST"  class="vertical">
    <input type="submit" class="btn btn-info mx-auto" value="Удалить игрока"/>
</form>
<form action="UpdatePlayer.jsp" method="POST" class="vertical">
    <input type="submit" class="btn btn-info mx-auto" value="Изменить игрока"/>
</form>
</div>
</div>
</body>
</html>
