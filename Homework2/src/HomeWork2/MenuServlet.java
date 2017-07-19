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
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<CreateFoodEntry> entries = (List<CreateFoodEntry>) getServletContext().getAttribute("entries");
		
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> SmOkE HoUsE CaFe!!!</h1>");
		
		out.println("<table border='2'>");
		out.println("<tr><th>Food Name</th><th>Price</th><th>Description</th><th>Add in a Cart</th></tr>");
		out.println("<body style='background-color:#66CCCC;'>");
		out.println(
				"<img  src=http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png alt= logo /> </br>");
		for (CreateFoodEntry entry : entries) {
			out.println("<tr>"  
					+"<td>" + entry.getName() + "  </td>" 
					+ "<td>"+ entry.getPrice() + " </td>" 
					+ "<td>"+ entry.getDescription() + " </td>" 
					+ "<td><img src='"+entry.getImg_url()+"'height='60' width='60'>"+"'</td >"
					+"<td><a href='menu/add?id="+entry.getId()+"'>Add in the cart</a></td>"
					
		+"</tr>"

			);
		}
		out.println("</table>");
		
		
		out.println("</br>");
		out.println("</br>");
		out.println("<footer><h6> @ Copyright CKamboj inc. All rights reserved.</h6></footer>");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
