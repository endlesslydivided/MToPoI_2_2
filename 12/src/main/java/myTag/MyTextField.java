package myTag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MyTextField extends TagSupport {

    public String value = "";
    public String label = "";
    public String name = "";

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() {
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.print("<label>" + label + "</label>"
                    + "<input name =\"" + name + "\" type = \"text\" width = \"150\""
                    + " maxlength= \"30\" value =\""+this.value+"\" />");
        } catch (IOException e) {
            System.out.println("MyLabledTextField: " + e);
        }

        return SKIP_BODY;
    }
}
