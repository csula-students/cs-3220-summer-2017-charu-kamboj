package homework3;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<img src='http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png 'class='logo'  >");      
		out.println("<h1>Smoke House Cafe</h1>");



	}

}

