package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//	List<Order> orderitems = (List<Order>) getServletContext().getAttribute("orderitems");
		List<CreateFoodEntry> cartentry = (List<CreateFoodEntry>) getServletContext().getAttribute("inventory");

		
		List<Order> orderitems=new ArrayList<>();
	
		for (CreateFoodEntry entry : cartentry) {

			
			orderitems.add(new Order(orderitems.size(),entry , request.getParameter("name"),"IN_QUEUE" ));
			getServletContext().setAttribute("orderitems", orderitems);
			
			System.out.println(request.getParameter("name"));
			System.out.println("CARTSERVLET--------------"+entry.getName());
		}

		cartentry.clear();
		
		
	response.sendRedirect("order-status.jsp");	
		
	}

}
