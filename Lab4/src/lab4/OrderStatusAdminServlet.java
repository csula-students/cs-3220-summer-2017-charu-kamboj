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
 * Servlet implementation class OrderStatusAdminServlet
 */
@WebServlet("/admin/orders") 
public class OrderStatusAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	List<Order> orders=new ArrayList<>();
    	CreateFoodEntry Doughnuts=new CreateFoodEntry(3,"Doughnuts",2.45);
    	CreateFoodEntry sandwitch=new CreateFoodEntry(4,"GrilledSandwitch",5.65);
    	List<CreateFoodEntry> food_items=new ArrayList<>();
    	food_items.add(Doughnuts);
    	List<CreateFoodEntry> food_items2=new ArrayList<>();
    	food_items2.add(sandwitch);
    	orders.add(new Order(0,food_items,"John","IN_PROGRESS"));
    	orders.add(new Order(1,food_items2,"Cher","IN_PROGRESS"));
    	getServletContext().setAttribute("orders", orders);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("../WEB-INF/admin/order-status.jsp")
            .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
