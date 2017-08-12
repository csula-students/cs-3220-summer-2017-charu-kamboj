package homework4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
		List<CreateFoodEntry> cart = new ArrayList<>();
		getServletContext().setAttribute("jdbc-cart", cart);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CreateFoodEntry> cart = (List<CreateFoodEntry>) getServletContext().getAttribute("list");
		request.setAttribute("cart", cart);
		
		//request.getRequestDispatcher("/WEB-INF/JDBC/Shopping-cart.jsp").forward(request, response); //rp
		request.getRequestDispatcher("JDBC/Shopping-cart.jsp").forward(request, response); //rp
}

}
