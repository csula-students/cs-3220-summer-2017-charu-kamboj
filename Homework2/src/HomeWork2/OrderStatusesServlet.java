package HomeWork2;

import java.io.IOException;
import java.io.PrintWriter;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
	+"<head>"
	+"<meta charset='utf-8'>"
	+"<meta http-equiv='x-ua-compatible' content='ie=edge'>"
	+"<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
	+"<title>Smoke House Cafe! </title>"
	+"<link rel='stylesheet' type='text/css' href='cs-3220-homework2/app.css'>"
	
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
	+"</div>"
	+"<main>"
	+"<br>"
	+"<br>"
	+		"<table class='cart-table' border='2'>"
	+		"<tr>"
	+			"<th>"
	+				"Item"
	+			"</th>"
	+			"<th>"
	+				"Customer Name"
	+			"</th>"
	+           "<th> Date Created</th>"
	+			"<th>"+
					"Item_Status"
	+			"</th>"
	+		"</tr>"
	+		"<tbody>"
	+"<tr>"
	+"<td> Pancakes </td>"
	+"<td> Eric</td>"
	+"<td>12-07-2017</td>"
	+"<td>Pending</td>"
	+"</tr>"
	+"<tr>"
	+"<td> Veggie Pizza </td>"
	+"<td> Maya</td>"
	+"<td>12-08-2017</td>"
	+"<td>In Progress</td>"
	+"</tr>"
	+"<tr>"
	+"<td> Pepperoni Supremo Pizza </td>"
	+"<td> Rodreguiez</td>"
	+"<td> 12-10-2017</td>"
	+"<td>Complete</td>"
	+"</tr>"
			
	+		"</tbody>"

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
		if (request.getParameter("delete") != null) {
			
		}
            
        
            
        
	}

}
