package playerDispatcher;

import DB.DBConnector;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;
import java.util.logging.Logger;
import org.apache.log4j.xml.DOMConfigurator;

@WebServlet(name = "playerDispatcher.AddPlayer", value = "/playerDispatcher.AddPlayer")
public class AddPlayer extends HttpServlet {

    private final static Logger log =
            Logger.getLogger(AddPlayer.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=Windows-1251");
        response.setCharacterEncoding("cp1251");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String lastname = request.getParameter("lastname");
        String fullName = surname + " " + name + " " + lastname;
        System.out.println("add "+fullName);
        DBConnector AddElementConnection = new DBConnector();
        try {
            AddElementConnection.SetConnection();
            AddElementConnection.Execute("SET NOCOUNT ON; INSERT INTO PLAYERS values ('" +number + "','" + fullName + "')");
            request.getRequestDispatcher("/main.jsp").forward(request, response);
            
            log.info("Новый игрок добавлен в команду:(" +number + " "+ fullName + ")" );
        } catch (SQLException exception) {
            request.setAttribute("Message",exception.getMessage());
            request.setAttribute("Cause",exception.getCause());
            request.setAttribute("Class",exception.getClass());
            request.setAttribute("ST",exception.getStackTrace());

            request.getRequestDispatcher("/errorPage.jsp").forward(request,response);
        }
    }

}


