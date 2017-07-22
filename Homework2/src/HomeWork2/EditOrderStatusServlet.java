package HomeWork2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditOrderStatusServlet
 */
@WebServlet("/admin/order/edit")
public class EditOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*int id=Integer.parseInt(request.getParameter("id"));
		@SuppressWarnings("unchecked")
		List<Orders> entries=(List<Orders>) getServletContext().getAttribute("entries");
		Orders leEntry=null;
		for(Orders entry:entries){
			if(entry.getID()==id){
				leEntry=entry;
			}
		}*/
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> SmOkE HoUsE CaFe!!!</h1>");
		out.println("<body style='background-color:#66CCCC;'>");
		out.println("<img  src=http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png alt= logo /> </br>");
		out.println("<h1>Edit Food</h1>");
		out.println("<form method=\"post\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Food Name:</td><td>");
		out.println("<input name='name' type='text' value=''readonly/><br> ");
		out.println("<hr>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("Customer Name:</td><td>");
		out.println("<input name='customer' type='text'readonly/><br> ");
		out.println("</td></tr><hr>");
		out.println("<tr><td>");
		out.println("Date Created:</td><td>");
		out.println("<input name='date' type='text' readonly/><br>");
		out.println("</td></tr><hr>");
		out.println("<tr><td>");
		out.println("Status:</td><td>");
		out.println("<input name='date' type='text' value=''/><br>");
		out.println("</td></tr><hr>");
		out.println("<tr><td>");
		out.println("<button> Edit</button>");
		out.println("</td></tr></table");
		out.println("</form>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
