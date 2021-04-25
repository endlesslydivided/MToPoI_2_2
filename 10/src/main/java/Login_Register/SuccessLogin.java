package Login_Register;

import DB.DBConnector;
import DB.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SuccessLogin", value = "/SuccessLogin")
public class SuccessLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnector connection = new DBConnector();
        try
        {
            connection.SetConnection();
            String login = request.getParameter("login");
            String password = String.valueOf(request.getParameter("password"));
            User user = new User(login,password);
            ResultSet queryResult = connection.ExecuteQuery("SELECT * FROM USERS WHERE login='" + login + "'");

            while (queryResult.next())
            {
                if(queryResult.getString("login") == login);
                {
                    System.out.println(user.HashPasswordBySalt(password,queryResult.getString("salt")));
                    if(queryResult.getString("password").equals(user.HashPasswordBySalt(password, queryResult.getString("salt"))))
                    {
                        System.out.println("test2");
                        response.sendRedirect("main.jsp");
                        return;
                    }
                }
            }
            response.setContentType("text/html;charset=Windows-1251");
            PrintWriter out = response.getWriter();
            out.write("<h1 style=\"text-align: center; color:red\" class=\"bg-warning font-weight-light\">Вход не прошёл успешно. Введите другой логин или пароль!</h1>");
            return;

        } catch (SQLException exception) {
                request.setAttribute("Message",exception.getMessage());
                request.setAttribute("Cause",exception.getCause());
                request.setAttribute("Class",exception.getClass());
                request.setAttribute("ST",exception.getStackTrace());
            System.out.println("\n Message: " +
                    (exception.getMessage() == null?"---":exception.getMessage())  + "\n Cause:" +
                    (exception.getCause()== null?"---":exception.getCause())+ "\n Class: " +
                    (exception.getClass()== null?"---":exception.getClass()) + "\n Stack trace: " +
                    (exception.getStackTrace()== null?"---":exception.getStackTrace()) + "\n" );
                request.getRequestDispatcher("/errorPage.jsp").forward(request,response);
        }
    }


}
