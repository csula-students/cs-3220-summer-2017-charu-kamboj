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
 * Servlet implementation class OrderStatusServlet
 */
@WebServlet("/OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(){
    	List<Order> orders=new ArrayList<>();
    	getServletContext().setAttribute("orders","orders");
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<JDBCOrder> orders = (List<JDBCOrder>) getServletContext().getAttribute("jdbc-orders");

		OrderDAO dao = new OrderDAO();
		request.setAttribute("orders", dao.list());

		
		request.getRequestDispatcher("/JDBC/Order.jsp")
			.forward(request, response);
}

}
