package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class RandomRestaurantListServlet
 */
@WebServlet("/suggest/restaurants/random/list")
public class RandomRestaurantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomRestaurantListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<RandomRestaurant> entries = (List<RandomRestaurant>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title> Random Restaurant Search</title>");
		out.println("</head>");
		out.println("<h1> What's for lunch?</h1>");
		out.println("<table border=2>");
		out.println("<tr>"+
		"<th>Name</th>"
				+"<th>URL</th>"
		+"<th>Design</th>"
				+"<th>Taste</th>"
		+"<th>Reviewers</th></tr>");
		for (RandomRestaurant entry : entries) {
			out.println("<tr>"  
					+"<td>" + entry.getId() + "  </td>" 
					+ "<td>"+ entry.getname() + " </td>" 
					+ "<td>"+ entry.geturl() + " </td>" 
					+ "<td><img src='"+entry.getDesignRating()+"'height='60' width='60'>"+"'</td >"
					+"<td> "+entry.getTasteRatings()
					+ "</td>" 
					
		+"</tr>");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
