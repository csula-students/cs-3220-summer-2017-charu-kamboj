package homework3;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/foods/create")
public class AdminFoodCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdminFoodCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<CreateFoodEntry> inventory=(List<CreateFoodEntry>) getServletContext().getAttribute("inventory");
		request.setAttribute("inventory", inventory);
		request.getRequestDispatcher("../../WEB-INF/admin/create-food.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   //doGet(request, response);
		PrintWriter out=response.getWriter();
		List<CreateFoodEntry> inventory=(List<CreateFoodEntry>) getServletContext().getAttribute("inventory");
		int id=inventory.size();
		String name=request.getParameter("name");
		
		inventory.add(new CreateFoodEntry(id,request.getParameter("name"),request.getParameter("desc"),request.getParameter("img"),Double.parseDouble(request.getParameter("price"))));
		request.setAttribute("inventory", inventory);
		
	
		response.sendRedirect("../foods");
		
	}

}
