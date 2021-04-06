package Servlets.ThirdServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(name = "SecondServletPost", urlPatterns = {"/SecondServletPost"})
public class SecondServletPost extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h4 style=\"text-align: center;\">Текущее время " + LocalTime.now() + "</h4>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
