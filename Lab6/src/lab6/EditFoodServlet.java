
package lab6;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditFoodServlet") 
public class EditFoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		CreateFoodEntryDAO dao = new CreateFoodEntryDAO();
		System.out.println(dao.get(id));
		CreateFoodEntry itemToEdit = dao.get(id).get();

		request.setAttribute("itemToEdit", itemToEdit);

		request.getRequestDispatcher("editfood.jsp")
            .forward(request, response);
	}

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreateFoodEntry Food_update = new CreateFoodEntry(
			Integer.parseInt(request.getParameter("id")),
			request.getParameter("name"),
			request.getParameter("img"),
			request.getParameter("desc"),
			Double.parseDouble(request.getParameter("price"))
			);

		CreateFoodEntryDAO dao = new CreateFoodEntryDAO();
		dao.update(Food_update);

		response.sendRedirect(request.getContextPath()+"/Inventory");
	}
}
