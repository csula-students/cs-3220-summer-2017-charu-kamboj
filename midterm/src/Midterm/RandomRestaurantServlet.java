package Midterm;

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
 * Servlet implementation class RandomRestaurantServlet
 */
@WebServlet("/suggest/restaurants/random")
public class RandomRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //public final String[] url;
    /**
     * @see HttpServlet#HttpServlet()
     */
	

    public RandomRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		@SuppressWarnings("unchecked")
		List<RandomRestaurant> entries=(List<RandomRestaurant>) getServletContext().getAttribute("entries");
		RandomRestaurant leEntry=null;
		for(RandomRestaurant entry:entries){
			if(entry.getId()==id){
				leEntry=entry;
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title> Random Restaurant Search</title>");
		out.println("</head>");
		out.println("<h1> What's for lunch?</h1>");
		out.println("<table border=2>");
		out.println("<tr>"
				+"<th>Restaurant Name</th>"
				+"<th>Design Ratings</th>"
				+"<th>Taste Ratings</th>");
		out.println("<tr>"
				+"<td>"+leEntry.getname()+"</td>");
		out.println("<td><form method=\"post\">"
				+ "<input name='designRate' id='design_rate_1' type='radio' value='1' checked>"
				+ "<label for='design_rate_1'>1</label><br>"

				+ "<input name='designRate' id='design_rate_2' type='radio' value='2'>"
				+ "<label for='design_rate_2'>2</label><br>" 
				+ "<input name='designRate' id='design_rate_3' type='radio' value='3'>"
				+ "<label for='design_rate_3'>3</label><br>" 
				+ "<input name='designRate' id='design_rate_4' type='radio' value='4'>"
				+ "<label for='design_rate_4'>4</label><br>" 
				+ "<input name='designRate' id='design_rate_5' type='radio' value='5'>"
				+ "<label for='design_rate_5'>5</label><br></td>" );
		out.println("<td><form method=\"post\">"
				+ "<input name='tasteRate' id='taste_rate_1' type='radio' value='1' checked>"
				+ "<label for='taste_rate_1'>1</label><br>"

				+ "<input name='tasteRate' id='taste_rate_2' type='radio' value='2'>"
				+ "<label for='taste_rate_2'>2</label><br>" 
				+ "<input name='tasteRate' id='taste_rate_3' type='radio' value='3'>"
				+ "<label for='taste_rate_3'>3</label><br>" 
				+ "<input name='tasteRate' id='taste_rate_4' type='radio' value='4'>"
				+ "<label for='taste_rate_4'>4</label><br>" 
				+ "<input name='tasteRate' id='taste_rate_5' type='radio' value='5'>"
				+ "<label for='taste_rate_5'>5</label><br>"
				+"<button>Submit Rating</button>"
				+ "</td></tr>");
		out.println("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
