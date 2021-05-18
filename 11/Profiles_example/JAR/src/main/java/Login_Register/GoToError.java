package Login_Register;

import org.apache.log4j.Logger;
import playerDispatcher.DeletePlayer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GoToError", value = "/GoToError")
public class GoToError extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("errorPage.jsp");
        response.setContentType("text/html;charset=Windows-1251");
        PrintWriter out = response.getWriter();
        Object errorMessage = request.getAttribute("Message");
        Object errorClass = request.getAttribute("Class");
        Object errorCause = request.getAttribute("Cause");
        Object stackTrace = request.getAttribute("ST");

        if (errorMessage != null)
        {
            out.println("<h1 style=\"text-align: center; color:green\">" + errorMessage.toString() + "</h1>");
        }
        if (errorClass != null)
        {
            out.println("<h1 style=\"text-align: center; color:green\">" + errorClass.toString() + "</h1>");
        }
        if (errorCause != null)
        {
            out.println("<h1 style=\"text-align: center; color:green\">" + errorCause.toString() + "</h1>");
        }
        if (stackTrace != null)
        {
            out.println("<h1 style=\"text-align: center; color:green\">" + stackTrace.toString() + "</h1>");
        }

    }
}
