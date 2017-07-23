package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderStatusesAdminServlet
 */
@WebServlet(loadOnStartup=1,urlPatterns={"/admin/orders"})
public class OrderStatusesAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusesAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	List<Orders> entries=new ArrayList<Orders>();
    	
    	getServletContext().setAttribute("entries", entries);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<CreateFoodEntry> entiries_food=(List<CreateFoodEntry>) getServletContext().getAttribute("entries_food");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
	+"<head>"
	+"<meta charset='utf-8'>"
	+"<meta http-equiv='x-ua-compatible' content='ie=edge'>"
	+"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
	+"<title>Smoke House Cafe! </title>"
	+"<link rel='stylesheet' href='<c:url value='http://localhost:8080/cs-3220-homework2/WEB-INF/app.css'/>'>"
	
	+"</head>"

	+"<body>"
	+"<div class='boxed'>"

	+"<blockquote>"
	+"<header >"
	+"<section class='container' >"
	+"<p>"
	+"<img class='logo' src='http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png'>"
	+"<h1 class='cafe-name'> SmOkE HoUsE CaFe!!!</h1>"
	
		+"<ul class='hyperlinks'>"
				+"<li><a href='food menu.html'>Menu|</a></li>"
				+"<li><a href='status.html'>Order|	</a></li>"
				+"<li><a href='index.html'>Statuses </a></li>"
		+"</ul>"
	+"</p>"	
	+"</section>"
	+"</header>"
	+"</blockquote>"
	+"</div>");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		CreateFoodEntry food=new CreateFoodEntry(0, "Veggie Pizza","You can also choose any crust with the Wisconsin 6 Cheese pizza, topped with robust tomato sauce and mozzarella, feta, provolone, cheddar, Parmesan, and Asiago cheeses, as well as a sprinkling of oregano. It's a dairy lover's delight. Have it on a Handmade Pan crust, a Brooklyn Style crust, or a Crunchy Thin crust.","http://cdn-image.myrecipes.com/sites/default/files/image/recipes/sl/03142008/pepperoni-pizza-sl-1599569-x.jpg", 6);
		List<Orders> entries_order=(List<Orders>)getServletContext().getAttribute("entries_order");
		//entries_order.add(new Orders(entries_order.size(), food,"Eric",date,));
	
		out.println("<main>"
	+"<br>"
	+"<br>"
	+		"<table class='cart-table' border='2'>"
	+		"<tr>"
	+			"<th>"
	+				"Food ID"
	+			"</th>"
	+			"<th>"
	+				"Item"
	+			"</th>"
	+			"<th>"
	+				"Customer Name"
	+			"</th>"
	+			"<th>"+
					"Date Created "
	+			"</th>"
	+			"<th>"
	+            "Status"
	+           "</th>"
	+		"</tr>"
	+		"<tbody>"
	+"<tr>");
		for(Orders order: entries_order)
	out.println("<td>"+order.getID()+"</td>"
			+ "<td>"+ order.getFood()+" </td>"
	+"<td>"+order.getName()+" </td>"
	+"<td>"+order.getDate()+"</td>"
	+"<td>"+order.getDate()+"</td>"
	+"<td><a href='../admin/order/?id=" + order.getID() + "'>Edit</a></td>"
	+"</tr>");
	
			
			out.println("</tbody>"

+			"</table>"
	+		"<br>"
	+		"<br>"
	+		"<button id='place'>Place your order</button>"

+"	</main>"


+"<footer>"
+	"<h6> @ Copyright CKamboj inc. All rights reserved."
+	"</h6>"
+	"</footer>"
	
+	"</body>"
+	"</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
