package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletefromCartServlet
 */
@WebServlet("/shopping-cart/delete")
public class DeletefromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletefromCartServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> cart_entries = (List<CreateFoodEntry>) getServletContext().getAttribute("entries_order2");
		int index = -1;
		for (int i = 0; i < cart_entries.size(); i++) {
			if (cart_entries.get(i).getId() == id) {
				index = i;
			}
		}
		cart_entries.remove(index);
		getServletContext().setAttribute("cart_entries", cart_entries);
		out.println("<h5>Item Removed</h5>");
		out.println("<a href='../shopping-cart'>back to Shopping Cart</a>");
	    
	}

	

}
