package homework4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/Shopping-cart/delete")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> cart = (List<CreateFoodEntry>) getServletContext().getAttribute("jdbc-cart");
		
		int index = -1;
		for (int i = 0; i < cart.size(); i ++) {
			if (cart.get(i).getId() == id) {
				index = i;
			}
		}
		cart.remove(index);
		getServletContext().setAttribute("jdbc-cart", cart);

		response.sendRedirect("../Shopping-cart");
	}

}
