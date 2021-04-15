package Login_Register;

import DB.DBConnector;
import DB.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SuccessLogin ", value = "/SuccessLogin ")
public class SuccessLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnector connection = new DBConnector();
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection.SetConnection();
            String login = request.getParameter("login");
            String password = String.valueOf(request.getParameter("password"));
            User user = new User(login,password);
            ResultSet queryResult = connection.Select("LOGIN =" + login,"USERS");

            while (queryResult.next()){
                if(queryResult.getString("LOGIN") == login);
                {
                    if(queryResult.getString("PASSWORD") == user.HashPasswordBySalt(password,queryResult.getString("SALT")))
                    {
                        response.sendRedirect("main.jsp");
                    }
                }
            }

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
                request.getRequestDispatcher("GoToError").forward(request,response);
        }
    }


}
