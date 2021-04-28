package Login_Register;

import DB.DBConnector;
import DB.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SuccessLogin", value = "/SuccessLogin")
public class SuccessLogin extends HttpServlet {

    private static final Logger logger = Logger.getLogger(
            SuccessLogin.class.getName());

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
                        response.sendRedirect("main.jsp");
                        String log4jConfPath = "D:\\ALEX\\STUDY\\4SEM_2COURSE\\MToPiI\\LABS\\10\\src\\resources\\log4j.properties";
                        PropertyConfigurator.configure(log4jConfPath);
                        logger.info("������������ ������� ���� :(" +login+ ")" );

                        return;
                    }
                }
            }
            request.setAttribute("message","�������� ����� ��� ������!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
