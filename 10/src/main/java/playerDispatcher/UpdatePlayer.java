package playerDispatcher;

import DB.DBConnector;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdatePlayer", value = "/UpdatePlayer")
public class UpdatePlayer extends HttpServlet {

    private static final Logger logger = Logger.getLogger(
            UpdatePlayer.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=WINDOWS-1251");
        String number = request.getParameter("number");
        String fullName = "";
        if(request.getParameter("name") != "") {
            fullName += request.getParameter("name")  + " ";
        }
        if(request.getParameter("surname") != "") {
            fullName += request.getParameter("surname")+ " ";
        }
        if(request.getParameter("lastname") != "") {
            fullName += request.getParameter("surname")+ " ";
        }
        DBConnector AddElementConnection = new DBConnector();
        try {
            AddElementConnection.SetConnection();
            if(fullName != "" && number != "")
            {
                AddElementConnection.Execute("UPDATE PLAYERS set number = '" + number + "', fullname ='" + fullName + "'");
                logger.info("Обновлена информация об игроке:("  + number + "," + fullName + ")" );
            }
            else if(fullName == "" && number != "")
            {
                AddElementConnection.Execute("UPDATE PLAYERS set number = '" + number + "'" );
                logger.info("Обновлена информация об игроке:("  + number +  ")" );
            }
            else if(fullName != "" && number == "")
            {
                AddElementConnection.Execute("UPDATE PLAYERS set fullname = '" + fullName + "'" );
                logger.info("Обновлена информация об игроке:(" + fullName + ")" );
            }
            else if(fullName == "" && number == "")
            {
                PrintWriter out = response.getWriter();
                out.write("<h1 style=\"text-align: center; color:red\" class=\"bg-warning font-weight-light\">Пустые поля!</h1>");

            }
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        } catch (SQLException exception) {
            request.setAttribute("Message",exception.getMessage());
            request.setAttribute("Cause",exception.getCause());
            request.setAttribute("Class",exception.getClass());
            request.setAttribute("ST",exception.getStackTrace());

            request.getRequestDispatcher("/errorPage.jsp").forward(request,response);
        }
    }
}
