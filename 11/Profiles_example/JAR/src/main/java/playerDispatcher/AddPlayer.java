package playerDispatcher;

import DB.DBConnector;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

@WebServlet(name = "playerDispatcher.AddPlayer", value = "/playerDispatcher.AddPlayer")
public class AddPlayer extends HttpServlet {

    private static final Logger logger = Logger.getLogger(
            AddPlayer.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=Windows-1251");
        response.setCharacterEncoding("cp1251");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String lastname = request.getParameter("lastname");
        String fullName = surname + " " + name + " " + lastname;
        DBConnector AddElementConnection = new DBConnector();
        try {
            AddElementConnection.SetConnection();
            AddElementConnection.Execute("SET NOCOUNT ON; INSERT INTO PLAYERS values ('" +number + "','" + fullName + "')");
            request.getRequestDispatcher("/main.jsp").forward(request, response);

            logger.info("Новый игрок добавлен в команду:(" +number + ", "+ fullName + ")" );
        } catch (SQLException exception) {
            request.setAttribute("Message",exception.getMessage());
            request.setAttribute("Cause",exception.getCause());
            request.setAttribute("Class",exception.getClass());
            request.setAttribute("ST",exception.getStackTrace());

            request.getRequestDispatcher("/errorPage.jsp").forward(request,response);
        }
    }

}


