package homework3;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart/delete")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> cartEntry = (List<CreateFoodEntry>) getServletContext().getAttribute("cartEntry");
		
		int index = -1;
		for (int i = 0; i < cartEntry.size(); i ++) {
			if (cartEntry.get(i).getId() == id) {
				index = i;
			}
		}
		cartEntry.remove(index);
		getServletContext().setAttribute("cartEntry", cartEntry);

		response.sendRedirect("shopping-cart.jsp");
	}

	

}