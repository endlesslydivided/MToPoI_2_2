package Login_Register;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(name = "GoToLoginIn", value = "/GoToLoginIn")
public class GoToLoginIn extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.sendRedirect("index.jsp");
            response.setContentType("text/html;charset=Windows-1251");
            PrintWriter out = response.getWriter();
            String message = request.getAttribute("Registration").toString();
            if (message != null) {
                out.println("<h1 style=\"text-align: center; color:green\">" + message + "</h1>");
            }
        }
        catch (Exception exception) {
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

