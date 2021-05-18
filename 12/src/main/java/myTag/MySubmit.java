package myTag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MySubmit extends TagSupport {
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    public int doStartTag() {
        String outputText = String.format("<input type=\"submit\" value=\"%s\">", label);
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.print(outputText);
        } catch (IOException e) {
            System.out.println("MYSubmit: " + e);
        }

        return EVAL_BODY_INCLUDE;
    }
}