import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyNameServlet", value = "/com-My-Name-Servlet")
public class comMyNameServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Меня зовут Ковалев Александр. БГТУ ПОИТ-4 2 курс";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}