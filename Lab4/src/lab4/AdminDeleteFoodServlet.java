package lab4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/foods/delete")
public class AdminDeleteFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdminDeleteFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> inventory=(List<CreateFoodEntry>) getServletContext().getAttribute("inventory");
		int index=-1;
		for(int i=0;i<inventory.size();i++)
		{
			if(inventory.get(i).getId()==id)
			{
				index=i;
			}
		}
		inventory.remove(index);
		getServletContext().setAttribute("inventory", inventory);

		response.sendRedirect("../foods");
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

