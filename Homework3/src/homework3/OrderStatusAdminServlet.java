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
@WebServlet("/admin/orders")
public class OrderStatusAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
	
	
	
	public void init() {

		//Sample

	}
    public OrderStatusAdminServlet() {
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
		List<Order> Homework3orderitems = (List<Order>) getServletContext().getAttribute("Homework3orderitems");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < Homework3orderitems.size(); i++) {
			if (Homework3orderitems.get(i).getId() == id) {
				leEntry = Homework3orderitems.get(i);
				index = i;
			}
			
		}
		
		
		
		String status = request.getParameter("status");
		System.out.println(status);
		

		System.out.println(status);

		Homework3orderitems.set(index, new Order(leEntry.getId(), leEntry.getItems(), leEntry.getCustomerName(),"In-Queue"));
		getServletContext().setAttribute("Homework3orderitems", Homework3orderitems);
		
		request.getRequestDispatcher("/admin/order-status.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
