package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inventory
 */
@WebServlet("/admin/foods")
public class Inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inventory() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
		List<CreateFoodEntry> inventory = new ArrayList<>();
		inventory.add(new CreateFoodEntry(0, "Pancakes", 4.75));
		inventory.add(new CreateFoodEntry(1, "Veggie-pizza",  8.5));
		getServletContext().setAttribute("inventory", inventory);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CreateFoodEntry> inventory = (List<CreateFoodEntry>) getServletContext().getAttribute("inventory");
		request.setAttribute("inventory", inventory);
		request.getRequestDispatcher("../WEB-INF/admin/inventory.jsp")
            .forward(request, response);
}
}
