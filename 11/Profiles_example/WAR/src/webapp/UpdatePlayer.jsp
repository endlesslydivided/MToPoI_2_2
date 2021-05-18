
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
    <title>Изменение игроков</title>
    <style>
        body,html {
            height: 100%;
        }
    </style>
</head>
<body>
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
<div class="container h-100 ">
    <div class="row align-items-center h-100">
        <div class="col-sm-5 col-md-5 col-lg-5 col-5 col-xl-5 mx-auto">
            <div class="card border-secondary mb-3 p-3" >
                <h3 style="color: red">${message}</h3>
                <div class="form-group">
                    <fieldset>
                        <legend>Изменение игрока</legend>
<form action="UpdatePlayer" method="post">
    <input name="id" class="form-control" type="text" placeholder="ID для изменения"/><br>
    <input name="number" class="form-control" type="text" placeholder="Новый номер"/><br>
    <input name="name" class="form-control" type="text" placeholder="Новое имя"/><br>
    <input name="surname" class="form-control" type="text" placeholder="Новая фамилия"/><br>
    <input name="lastname" class="form-control" type="text" placeholder="Новое отчество"/><br>
    <input type="submit" class="btn btn-info mx-auto" value="Изменить"/>
</form>
                    </fieldset>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>