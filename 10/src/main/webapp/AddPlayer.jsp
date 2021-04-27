<%@ page contentType="text/html;charset=WINDOWS-1251" pageEncoding="WINDOWS-1251"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=WINDOWS-1251">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src = "http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <title>���������� �������</title>
    <style>
        body,html {
            height: 100%;
        }
    </style>
</head>
<body>
<div class="container h-100 ">
    <div class="row align-items-center h-100">
        <div class="col-sm-5 col-md-5 col-lg-5 col-5 col-xl-5 mx-auto">
            <div class="card border-secondary mb-3 p-3" >
                <h3 style="color: red">${message}</h3>
                <div class="form-group">
                    <fieldset>
                        <legend>����� �����</legend>
<form action="playerDispatcher.AddPlayer" method="post">
    <input name="number"  class="form-control" type="text" placeholder="�����"/><br>
    <input name="name" class="form-control" type="text" placeholder="���"/><br>
    <input name="surname" class="form-control"  type="text" placeholder="�������"/><br>
    <input name="lastname" class="form-control" type="text" placeholder="��������"/><br>
        <input type="submit" class="btn btn-info mx-auto" value="��������"/>
</form>
                    </fieldset>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

