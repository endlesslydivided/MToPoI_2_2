package myTag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class MyTable extends TagSupport {

    public int doStartTag() {
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.print("<table border=\"1\" >" +
                    "<tr>" +
                    "<th>Parameter</th><th>Value</th>" +
                    "</tr>");
            Enumeration params = pageContext.getRequest().getParameterNames();
            while(params.hasMoreElements()) {
                String paramName = (String)params.nextElement();
                jspWriter.print("<tr><td>" + paramName + "</td>");
                String paramValue = pageContext.getRequest().getParameter(paramName);
                jspWriter.println("<td> " + paramValue + "</td></tr>");
            }
        } catch (IOException e) {
            System.out.println("MySubmit: " + e);
        }

        return EVAL_BODY_INCLUDE;
    }
}
