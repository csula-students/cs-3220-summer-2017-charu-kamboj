package HomeWork2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFoodAdminServlet
 */
@WebServlet("/admin/foods/edit/")
public class EditFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		@SuppressWarnings("unchecked")
		List<CreateFoodEntry> entries=(List<CreateFoodEntry>) getServletContext().getAttribute("entries");
		CreateFoodEntry leEntry=null;
		for(CreateFoodEntry entry:entries){
			if(entry.getId()==id){
				leEntry=entry;
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> SmOkE HoUsE CaFe!!!</h1>");
		out.println("<body style='background-color:#66CCCC;'>");
		out.println("<img  src=http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png alt= logo /> </br>");
		out.println("<h1>Edit Food</h1>");
		out.println("<form method=\"post\">");
		out.println("Food Name:<input name='name' type='text' value='"+leEntry.getName()+"'/><br> ");
		out.println("<hr>");
		out.println("Description:<textarea name='Description' type='text'/>" +leEntry.getDescription()+"</textarea></br>");	
		out.println("<hr>");
		out.println("Image URL:<input name='img_url' type='text'value='"+leEntry.getImg_url()+"'/><br> ");
		out.println("<hr>");
		out.println("Price:<input name='price' type='text'"+leEntry.getPrice()+"'/><br> ");
		out.println("<hr>");
		out.println("<button> Edit</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFoodEntry> entries = (List<CreateFoodEntry>) getServletContext().getAttribute("entries");
		CreateFoodEntry leEntry = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getId() == id) {
				leEntry = entries.get(i);
				index = i;
			}
		}
		entries.set(index, new CreateFoodEntry(
			leEntry.getId(),
			request.getParameter("name"),
			request.getParameter("Description"),
			request.getParameter("img_url"),
			Integer.parseInt(request.getParameter("price"))
		));
		getServletContext().setAttribute("entries", entries);

		response.sendRedirect("../FoodMenuServlet");
	}

}
