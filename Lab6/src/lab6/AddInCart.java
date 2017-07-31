package lab6;

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
		CreateFoodEntryDAO dao=new CreateFoodEntryDAO();
		request.setAttribute("list", dao.list());
		int id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(request.getParameter("id"));
		
		
		List<CreateFoodEntry>items=(List<CreateFoodEntry>)getServletContext().getAttribute("");
	
		CreateFoodEntry entry=null;
		
		for(CreateFoodEntry fooditems: items){
			if(fooditems.getId()==id){
				entry=fooditems;
			}
		}
		
		
}
		

	

	

}
