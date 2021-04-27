package Login_Register;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GoToRegister", value = "/GoToRegister")
public class GoToRegister extends HttpServlet {
    private static final Logger logger = Logger.getLogger(
            GoToError.class.getName());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Переход на страницу RegistrationForm.jsp");
        response.sendRedirect("RegistrationForm.jsp");

    }
}
