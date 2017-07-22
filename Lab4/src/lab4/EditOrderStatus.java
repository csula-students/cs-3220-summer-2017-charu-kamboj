package lab4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditOrderStatus
 */
@WebServlet("/admin/orders/edit")
public class EditOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderStatus() {
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
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");

		Order orderToEdit = null;
		for (Order order : orders) {
			if (order.getId() == id) {
				orderToEdit = order;
			}
		}

		request.setAttribute("orderToEdit", orderToEdit);
		request.getRequestDispatcher("../../WEB-INF/admin/edit-order.jsp")
			.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		Order orderToEdit = null;
		int index = -1;
		for (int i = 0; i < orders.size(); i ++) {
			if (orders.get(i).getId() == id) {
				orderToEdit = orders.get(i);
				index = i;
			}
		}
		
		orders.set(index, new Order(
			orderToEdit.getId(),
			orderToEdit.getItems(),
			orderToEdit.getCustomerName(),
			request.getParameter("new_status")
			
		));

		getServletContext().setAttribute("orders", orders);

		response.sendRedirect("../orders");
	}
	

}
