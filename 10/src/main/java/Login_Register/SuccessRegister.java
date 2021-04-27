package Login_Register;

import DB.DBConnector;
import DB.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SuccessRegister", value = "/SuccessRegister")
public class SuccessRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnector connection = new DBConnector();
        try
        {
            response.setContentType("text/html;charset=Windows-1251");
            connection.SetConnection();
            String login = request.getParameter("login");
            String password = String.valueOf(request.getParameter("password"));
            if(login.equals("")) {
                request.setAttribute("message","Введите логин");
                request.getRequestDispatcher("/RegistrationForm.jsp").forward(request, response);
            }

            if(password.equals("")) {
                request.setAttribute("message","Введите пароль");
                request.getRequestDispatcher("/RegistrationForm.jsp").forward(request, response);
            }

            User user = new User(login,password);
            System.out.println("SELECT USERS.login FROM USERS WHERE login='" + login + "'");
            ResultSet queryResult = connection.ExecuteQuery("SELECT USERS.login FROM USERS WHERE login='" + login + "'");


            while (queryResult.next())
            {
                if(queryResult.getString("login") == login);
                {
                    request.setAttribute("message","Такой пользователь уже существует");
                    request.getRequestDispatcher("/RegistrationForm.jsp").forward(request, response);
                    return;
                }
            }
            connection.Execute("SET NOCOUNT ON; INSERT INTO USERS values ('" +login + "','" + user.HashPassword()+ "','"+user.getSalt() + "')");
            request.setAttribute("Registration","Регистрация прошла успешно");
            request.getRequestDispatcher("/GoToLoginIn").forward(request,response);
            return;


        } catch (SQLException exception) {
            request.setAttribute("Message",exception.getMessage());
            request.setAttribute("Cause",exception.getCause());
            request.setAttribute("Class",exception.getClass());
            request.setAttribute("ST",exception.getStackTrace());

            request.getRequestDispatcher("/errorPage.jsp").forward(request,response);
        }
    }
}
