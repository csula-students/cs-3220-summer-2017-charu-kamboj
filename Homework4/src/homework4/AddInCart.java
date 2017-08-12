package homework4;

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
 * Servlet implementation class AddInCart
 */
@WebServlet("/AddInCart")
public class AddInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddInCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		CreateFoodEntryDAO dao = new CreateFoodEntryDAO();
		CreateFoodEntry itemToAdd = dao.get(id).get();
		//CreateFoodEntry list_of_items=(CreateFoodEntry) dao.list();
		//CreateFoodEntryDAO dao1=new CreateFoodEntryDAO();
		
		List<CreateFoodEntry> cart = new ArrayList<CreateFoodEntry>();//rejun
		//List<CreateFoodEntry> cart = (List<CreateFoodEntry>) getServletContext().getAttribute("list");
		//cart = (List<CreateFoodEntry>) getServletContext().getAttribute("list");
		PrintWriter out = response.getWriter();
		boolean item_already_in_cart = false;
		//rejun
		if (!cart.isEmpty()){
			for (CreateFoodEntry item : cart) {
				if (item.getId() == itemToAdd.getId()) {
					item_already_in_cart = true;
					//int current_quantity = item.getQuantity();
					//item.setQuantity(current_quantity + 1);
				}
			}
		}
		if (item_already_in_cart == false) {
			cart.add(itemToAdd);
		}

		getServletContext().setAttribute("cart", cart);

		response.sendRedirect("CartServlet");
}
		
		
}
		

	

	


