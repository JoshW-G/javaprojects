

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderFormServlet
 */
public class OrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String desc = request.getParameter("desc");
				String code = request.getParameter("code");
				String quant = request.getParameter("quant");
				String deliv = request.getParameter("deliv");
				String cust_id = request.getParameter("cust_id");
				PrintWriter pw = response.getWriter();
				pw.append("<html><head><title>Testing doPostLogin</title></head><body>");
				if(desc == null || "".equals(desc)||(code == null || "".equals(code))||(quant == null || "".equals(quant))||(cust_id == null || "".equals(cust_id))) {
					pw.append("<h1>Please Enter Order Information</h1>");
					
				}
				else {
					
					Enumeration order;
				    Vector orderVals = new Vector();
					orderVals.add(desc);
					orderVals.add(code);
					orderVals.add(quant);
					orderVals.add(deliv);
					orderVals.add(cust_id);
					order = orderVals.elements();
					pw.append("<h1>Testing doPost</h1>");
					pw.append("<br>Description = "+order.nextElement());
					pw.append("<br>Code = "+order.nextElement());
					pw.append("<br>Quantity = "+order.nextElement());
					pw.append("<br>Delivery = "+order.nextElement());
					pw.append("<br>Customer_Id = "+order.nextElement());
				}
				pw.append("</body></html>");
	}

}
