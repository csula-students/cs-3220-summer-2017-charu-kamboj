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
 * Servlet implementation class AddinCart
 */
@WebServlet("/menu/add")
public class AddinCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddinCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> entries = (List<CreateFoodEntry>) getServletContext().getAttribute("entries");

		CreateFoodEntry ent = null;

		for (CreateFoodEntry entry : entries) {
			if (entry.getId() == id) {
				
				ent = entry;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<CreateFoodEntry> cart = (List<CreateFoodEntry>) getServletContext().getAttribute("cart");

		cart.add(new CreateFoodEntry(id, ent.getName(), ent.getDescription(), ent.getImg_url(),
				ent.getPrice()));

		getServletContext().setAttribute("cart", cart);

		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
		out.println("<title>Shopping Cart </title>");
		out.println("<h2>You put " + ent.getName() + " in your cart.</h2>");
		out.println("<button onclick=\"location.href='../menu'\">Go back to FoodMenu</button>");
		out.println("<button onclick=\"location.href='../shopping-cart'\">See a Shopping Cart </button>");

}

	

}
