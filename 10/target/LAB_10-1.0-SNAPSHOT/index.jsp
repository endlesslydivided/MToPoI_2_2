<%@ page contentType="text/html; charset=WINDOWS-1251" pageEncoding="WINDOWS-1251" %>
<!DOCTYPE html>
<html>
<head>
    <title>¬ход</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
    body,html {
        height: 100%;
    }
</style>
</head>
<body class="">

<div class="container h-100">
    <div class="row align-items-center h-100">
        <div class="col-sm-5 col-md-5 col-lg-5 col-5 col-xl-5 mx-auto">
            <div class="">
                <h3 style="color: red">${message}</h3>
                <div class="form-group">
                    <fieldset>
                            <legend>¬ход</legend>

                            <form action="SuccessLogin " method="POST">

                            <label for="login">Ћогин</label>
                            <input name="login"   class="form-control" id="login" placeholder="¬ведите логин">

                            <label for="password">ѕароль</label>
                            <input name="password"   type="password" class="form-control" id="password" placeholder="¬ведите пароль">

                            <input  type="submit" class="btn btn-info mx-auto" value="¬ход"/>
                        </form>
                        <form action="GoToRegister" method="POST">
                            <input type="submit"  class="btn btn-info mx-auto" value="–егистраци€"/>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>