package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddinCart
 */
@WebServlet("/AddinCart")
public class AddinCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddinCart() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    	List<CreateFoodEntry> cartentry=new ArrayList<>();
    	getServletContext().setAttribute("cartentry", cartentry);
    	
    	List<CreateFoodEntry> items=new ArrayList<>();
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		
		
		List<CreateFoodEntry>items=(List<CreateFoodEntry>)getServletContext().getAttribute("inventory");
	
		CreateFoodEntry entry=null;
		
		for(CreateFoodEntry fooditems: items){
			if(fooditems.getId()==id){
				entry=fooditems;
			}
		}
		List<CreateFoodEntry>cartentry=(List<CreateFoodEntry>)getServletContext().getAttribute("cartentry");
	cartentry.add(new CreateFoodEntry(id, entry.name, entry.description,entry.img_url,entry.getPrice()));
			System.out.println(entry.name);
			System.out.println(entry.description);
			System.out.println(entry.img_url);
			System.out.println(entry.getPrice());

			getServletContext().setAttribute("cartentry", cartentry);
			
			response.sendRedirect("confirmorder.jsp");
	}


	

}
