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

@WebServlet(name = "SuccessRegister", value = "/SuccessRegister")
public class SuccessRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnector connection = new DBConnector();
        try
        {
            connection.SetConnection();
            String login = request.getParameter("login");
            String password = String.valueOf(request.getParameter("password"));
            User user = new User(login,password);
            ResultSet queryResult = connection.Select("LOGIN =" + login,"USERS");

            while (queryResult.next())
            {
                if(queryResult.getString("LOGIN") != login);
                {
                    connection.Insert("USERS",login,user.HashPassword(),user.getSalt());
                    request.setAttribute("Registration","Регистрация прошла успешно");
                    request.getRequestDispatcher("GoToLoginIn").forward(request,response);
                    return;
                }
            }
            PrintWriter out = response.getWriter();
            out.println("<h1 style=\"text-align: center; color:red\">Регистрация не прошла успешно. Придумайте другой логин!</h1>");


        } catch (SQLException exception) {
            request.setAttribute("Message",exception.getMessage());
            request.setAttribute("Cause",exception.getCause());
            request.setAttribute("Class",exception.getClass());
            request.setAttribute("ST",exception.getStackTrace());
            System.out.println("\n Message: " +
                    (exception.getMessage() == null?"---":exception.getMessage())  + "\n Cause:" +
                    (exception.getCause()== null?"---":exception.getCause())+ "\n Class: " +
                    (exception.getClass()== null?"---":exception.getClass()) + "\n Stack trace" +
                    (exception.getStackTrace()== null?"---":exception.getStackTrace()) + "\n" );
            request.getRequestDispatcher("GoToError").forward(request,response);
        }
    }
}
