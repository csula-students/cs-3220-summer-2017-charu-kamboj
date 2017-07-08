package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Restaurants
 */
@WebServlet("/suggest/restaurants/")
public class Restaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[]url ;
	int id[] ;
	String name[];
	int [] designRatings ;
	int [] tasteRatings ;
	RandomRestaurant tempid;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init()
    {
    	String[] url=new String[22];
    	int[] id=new int[22];
    	String[] name=new String[22];
    	int[] designRatings=new int[22];
    	int[] tasteRatings=new int[22];
    	
    	
    	List<RandomRestaurant> entries=new ArrayList<>();
    	for(int i=1;i<=9;i++)
    	{
    		entries.add(new RandomRestaurant(i,"Students's"+i+"Restaurant","http://cs3.calstatela.edu:8080/cs3220xstu0"+i+"/menu", tasteRatings, tasteRatings));
    		
    	}
    	for(int i=10;i<=22;i++)
    	{
    		entries.add(new RandomRestaurant(i,"Students's"+i+"Restaurant","http://cs3.calstatela.edu:8080/cs3220xstu"+i+"/menu", tasteRatings, tasteRatings));
    		
    	}
    }
    
    public RandomRestaurant getRandomRestaurant(List<RandomRestaurant> list) {
    	return list.get(new Random().nextInt(list.size()));
    }
    public Restaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<RandomRestaurant> entries = (List<RandomRestaurant>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title> Random Restaurant Search</title>");
		out.println("</head>");
		out.println("<h1> What's for lunch?</h1>");
		out.println("<p><center><button input type='submit' value='click' name='randomrestaurant' >Feeling Lucky</button></center>");
		out.println("<center><button input type ='submit' value='click' name='randomlist' > See the list</button></center></p>");
	//for (RandomRestaurant entry : entries) {
		//out.println("'<a href='/suggest/restaurants/random?id=" + entry.getId() + "'>Feeling Kucky</a> ");}
		out.println("<a href='http://localhost:8080/Cs-3220-Midterm1/suggest/restaurants/random/list'>See the list</a> ");
		
		out.println("<style>"
				+ "h1{"
				+ "display:flex;"
				+ "justify-content:space-around;"
				+ "}"
				+"button{"
				+"display:flex;"
				+ "justify-content:space-around;"
				+ "align-item:center;"
				+ "}"
				+"</style>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<RandomRestaurant> entries = (List<RandomRestaurant>) getServletContext().getAttribute("entries");
		if(request.getParameter("randomrestaurant")!=null){
			response.sendRedirect("../suggest/restaurants/random?id=" + entries.size() );
		}
		if(request.getParameter("randomlist")!=null){
			response.sendRedirect("../suggest/restaurants/random/list" );
		}
	}

}
