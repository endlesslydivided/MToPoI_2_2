package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/FilterToRegister")
public class FilterToRegister implements Filter {

    private FilterConfig config;
    private boolean active = false;
    private static ArrayList<String> pages;

    public void init(FilterConfig fConfig) {
        config = fConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        // ???????????? ????? ?? ????????????
        String[] list = req.getRequestURI().split("/");
        // ????????? ???????????? ????????
        String page = null;
        if (list[list.length - 1].indexOf(".jsp") > 0)
        {
            page = list[list.length - 1];
        }
        if ((page != null) && page.equalsIgnoreCase("main.jsp")) {
            if (pages.contains("main.jsp"))
            {
                chain.doFilter(request, response);
            } else {
                ServletContext ctx = config.getServletContext();
                RequestDispatcher dispatcher = ctx.getRequestDispatcher("/registration.jsp");
                dispatcher.forward(request, response);
            }
            return;
        } else if (page != null) {
            if (!pages.contains(page))
                pages.add(page);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        config = null;
    }
}
