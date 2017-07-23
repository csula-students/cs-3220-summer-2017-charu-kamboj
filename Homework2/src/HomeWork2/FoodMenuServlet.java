package homework2;

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
 * Servlet implementation class FoodMenuServlet
 */
@WebServlet("/admin/foods")
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	public void init() {
		// init the application scope to have pre-set values
		List<CreateFoodEntry> entries = new ArrayList<>();
		entries.add(new CreateFoodEntry(entries.size(), "Veggie Pizza","You can also choose any crust with the Wisconsin 6 Cheese pizza, topped with robust tomato sauce and mozzarella, feta, provolone, cheddar, Parmesan, and Asiago cheeses, as well as a sprinkling of oregano. It's a dairy lover's delight. Have it on a Handmade Pan crust, a Brooklyn Style crust, or a Crunchy Thin crust.","http://cdn-image.myrecipes.com/sites/default/files/image/recipes/sl/03142008/pepperoni-pizza-sl-1599569-x.jpg", 6));
		entries.add(new CreateFoodEntry(entries.size(), "Pizza","Pepperoni, (also known as pepperoni sausage), is an American variety of salami, made from cured pork and beef mixed together and seasoned with paprika or other chili pepper. ... Thinly sliced pepperoni is a popular pizza topping in American-style pizzerias and is used as filling in the West Virginia pepperoni roll.","http://food.fnr.sndimg.com/content/dam/images/food/fullset/2010/1/21/2/FNM_030110-Insert-012_s4x3.jpg.rend.hgtvcom.616.462.jpeg", 6));
		getServletContext().setAttribute("entries", entries);
	}
    public FoodMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<CreateFoodEntry> entries = (List<CreateFoodEntry>) getServletContext().getAttribute("entries");
		
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> SmOkE HoUsE CaFe!!!</h1>");
		
		out.println("<table border='2'>");
		out.println("<tr><th>Food Name</th><th>Price</th><th>Description</th></tr>");
		out.println("<body style='background-color:#66CCCC;'>");
		out.println(
				"<img  src=http://www.wgprovisions.com/wp-content/uploads/2015/12/smoke_house_creations_icon_color-1.png alt= logo /> </br>");
		for (CreateFoodEntry entry : entries) {
			out.println("<tr>"  
					+"<td>" + entry.getName() + "  </td>" 
					+ "<td>"+ entry.getPrice() + " </td>" 
					+ "<td>"+ entry.getDescription() + " </td>" 
					+ "<td><img src='"+entry.getImg_url()+"'height='60' width='60'>"+"'</td >"
					+"<td><a href='admin/foods/edit?id=" + entry.getId() + "'>Edit</a> "
					+ "</td>" 
					+"<td><a href='admin/foods/delete?id="+entry.getId()+"'>Delete</a>"
					+"</td>"
		+"</tr>"

			);
		}
		out.println("</table>");
		out.println("<a href='../admin/foods/create'>Add Food</a>");
		out.println("<a href='../menu'>Go to the main menu</a>");
		
		out.println("</br>");
		out.println("</br>");
		
		out.println("<footer><h6> @ Copyright CKamboj inc. All rights reserved.</h6></footer>");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
