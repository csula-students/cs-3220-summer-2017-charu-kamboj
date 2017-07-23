package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/shopping-cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
    	List<CreateFoodEntry> entries_cartz=new ArrayList<>();
    	getServletContext().setAttribute("entries_cartz", entries_cartz);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		List<CreateFoodEntry> entries_foodz = (List<CreateFoodEntry>) getServletContext().getAttribute("entries_foodz");

		response.setContentType("text/html");

		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		out.println("<title> Shopping Cart </title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<header>");

		out.println("<h1><img src=" + "\"" + "http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png" + "\""
				+ " width=\"100\" height=\"100\"> Smoke House Cafe! </h1>");
		out.println("<nav>");
		out.println("<ul>");
		out.println("<li><a href=\"orders\">HomePage(Order Status)</a></li>");
		out.println("<li><a href=\"menu\">Menu</a></li>");
		out.println("<li><a href=\"shopping-cart\">Cart</a></li>");
		out.println("</ul>");
		out.println("</nav>");

		out.println("</header>");

		out.println("<main>");

		out.println("<h2> Shopping Cart </h2>");

		List<CreateFoodEntry> entries_cartz = (List<CreateFoodEntry>) getServletContext().getAttribute("cart");

		if (entries_cartz.size() == 0) {
			out.println("<table>" + "<tbody>" + "<tr>" + "<td>");

			out.println("Your cart is empty. <br>");
			out.println("Click <a href=\"menu\">Menu</a> to order our nice foods !");

			out.println("</td>" + "</tr>" + "<tbody>" + "</table>");

		}

		else {
			out.println("<table>");
			out.println("<thead>" + "<tr>" + "<th>" + "Food ID" + "</th>" + "<th>" + "Food Name" + "</th>" + "<th>"
					+ "Food Description" + "</th>" + "<th>" + "Food Image" + "</th>" + "<th>" + "Food Price" + "</th>"
					+ "<th>" + " Remove From Cart " + "</th>" + "</tr>" + "<thead>");

			for (CreateFoodEntry e : entries_cartz) {

				out.println("<tbody>" + "<tr>" + "<td>" + e.getId() + "</td>" + "<td>" + e.getName() + "</td>"
						+ "<td>" + e.getDescription() + "</td>" + "<td><img src=" + "\"" + e.getImg_url() + "\""
						+ " width=\"200\" height=\"100\"></td>" + "<td> $" + e.getPrice() + "</td>"
						+ "<td><a href='shopping-cart/delete?id=" + e.getId() + "'>Remove</a>" + "</td>" + "</tr>"
						+ "</tbody>");
			}

			out.println("</table>");

			out.println("<h3> Type Your Name </h3>");

			out.println("<form method=\"post\">");
			out.println("<label>Your Name:</label><br>");
			out.println("<input name='name' type='text'/></br><br>");
			out.println("<button>Confirm Your order</button>");
			out.println("</form>");

		}

		out.println("</main>");

		out.println("<footer><h6> @ Copyright CKamboj inc. All rights reserved.</h6></footer>");
out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Orders> entries_order2 = (List<Orders>) getServletContext().getAttribute("entries_order2");
		List<CreateFoodEntry> entries_cartz = (List<CreateFoodEntry>) getServletContext().getAttribute("entries_cartz");
		

		for (CreateFoodEntry entry : entries_cartz) {

			entries_order2
					.add(new Orders(entries_order2.size(), entry, request.getParameter("name"), "IN_QUEUE", new Date()));
			getServletContext().setAttribute("entries_order2", entries_order2);
		}

		entries_cartz.clear();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		out.println("<title> Shopping Cart </title>");
		out.println("<h2>Thank you for your order !</h2>");
		out.println("<button onclick=\"location.href='/orders'\">See your orders</button>");
}
	

}
