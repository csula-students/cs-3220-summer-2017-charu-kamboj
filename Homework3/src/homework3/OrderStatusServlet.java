package homework3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class OrderStatusServlet
 */
@WebServlet("/OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
	
	
	
	public void init() {

		//Sample

	}
    public OrderStatusServlet() {
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
		List<Order> orderitems = (List<Order>) getServletContext().getAttribute("inventory");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < orderitems.size(); i++) {
			if (orderitems.get(i).getId() == id) {
				leEntry = orderitems.get(i);
				index = i;
			}
			
		}
		
		
		
		String status = request.getParameter("status");
		System.out.println(status);
		

		System.out.println(status);

		orderitems.set(index, new Order(leEntry.getId(), leEntry.getItems(), leEntry.getCustomerName(), leEntry.getStatus()));
		getServletContext().setAttribute("orderitems", orderitems);
		
		request.getRequestDispatcher("/admin/order-statuses.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
