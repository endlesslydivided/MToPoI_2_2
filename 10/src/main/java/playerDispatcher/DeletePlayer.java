package playerDispatcher;

import DB.DBConnector;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeletePlayer", value = "/DeletePlayer")
public class DeletePlayer extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=WINDOWS-1251");
        String ID = request.getParameter("ID");
        DBConnector AddElementConnection = new DBConnector();
        try {
            AddElementConnection.SetConnection();
            AddElementConnection.Execute("DELETE PLAYERS WHERE id =  '" +ID + "'");
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
