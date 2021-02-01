

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomFactServlet
 */
public class RandomFactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int hits = 0; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomFactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		hits++;
		String fact1 = "In Colombia, dried ants replace popcorn as the typical movie theater snack.";
		String fact2 = "There was a third Apple founder. Ronald Wayne sold his 10 percent stake for $800 in 1976.";
		String fact3 = "The first electronic computer ENIAC weighed more than 27 tons and took up 1800 square feet.";
		String fact4 = "Only about 10% of the world's currency is physical money, the rest only exists on computers";
		String fact5 = "TYPEWRITER is the longest word that you can write using the letters only on one row of the keyboard of your computer";
		pw.append("<html><head><title>Random Fact Generator</title></head><body><h1> FACT</h1><br>");
		int i = (int)(Math.random()*5);
		if (i==1) {
			pw.append(fact1);
		}
		if (i==2) {
			pw.append(fact2);
		}
		if (i==3) {
			pw.append(fact3);
		}
		if (i==4) {
			pw.append(fact4);
		}
		if (i==5) {
			pw.append(fact5);
		}
		pw.append("<br>Site hits = "+ hits);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
