package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersAdminServlet
 */
@WebServlet("/orders")
public class OrderStatusesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    	List<Orders>HOrder2=new ArrayList<>();
    	getServletContext().setAttribute("HOrder2", HOrder2);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<CreateFoodEntry>HCartEntry=(List<CreateFoodEntry>)getServletContext().getAttribute("HCartEntry");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		
		
		out.println("<h1> Smoke House Cafe!</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2> Food Items List </h>");
		out.println("<table border=1, padding=1px>");
		
				out.println("<main>");

		out.println("<h2> Order Statuses </h2>");

		List<Orders> Horderitems = (List<Orders>) getServletContext().getAttribute("Horderitems");

		if (Horderitems.size() == 0) {
			out.println("<table>" + "<tbody>" + "<tr>" + "<td>");

			out.println("You do not have any order. <br>");
			out.println("Click <a href=\"menu\">Menu</a> to order food !");

			out.println("</td>" + "</tr>" + "<tbody>" + "</table>");

		} else {
			out.println("<table border=2>");
			out.println("<thead>" + 
							"<tr>" + 
							"<th>" + " Name" + "</th>" + 
							"<th>"+ " Image" + "</th>" + 
							"<th>" + " Name" + "</th>" + 
							"<th>" + " Status" + "</th>"
							+ "<th>" + " Date " + 
							"</th>" + "</tr>" + "<thead>");

			for (Orders orders : Horderitems)

				out.println("<tbody>" 
							+ "<tr>" +
							"<td>" + orders.getFood().getName()+ "</td>" + 
							"<td>"+"<img src= "+orders.getFood().getImg_url()+" width=70px > </td>" 
							+ "<td>" + orders.getName() + "</td>" + 
							"<td>"+ orders.getStatus().toString()+ "</td>" + 
							"<td>" + orders.getDate() + "</td>" + 
							"</tr>"
						+ "</tbody>");

		}

		out.println("</table>");

		
}
}
